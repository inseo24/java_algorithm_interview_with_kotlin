class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 모든 특수문자를 공백으로 대체하고 소문자로 변환
        String normalizedStr = paragraph.replaceAll("\\W+", " ").toLowerCase();

        // 금지 단어 집합
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        
        // 빈도수 계산
        Map<String, Integer> freq = new HashMap<>();

        for (String word: normalizedStr.split("\\s+")) { // "\\s+"" : 여러 공백을 한 번에 분리
            if (!bannedWords.contains(word) && !word.isEmpty()) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        // 가장 많이 등장한 단어 찾기
        String mostCommon = "";
        int maxCount = 0;
        
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }
        
        return mostCommon;
    }
}

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> counts = new HashMap<>();
        
        Arrays.stream(paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+"))
              .filter(word -> !word.isEmpty() && !bannedSet.contains(word))
              .forEach(word -> counts.put(word, counts.getOrDefault(word, 0) + 1));
        
        return counts.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse("");
    }
}