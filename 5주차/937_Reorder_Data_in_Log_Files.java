class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        // 문자 로그와 숫자 로그 분리
        for (String log : logs) {
            String[] parts = log.split(" ", 2);
            if (Character.isDigit(parts[1].charAt(0))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        // 문자 로그 정렬
        letterLogs.sort((log1, log2) -> {
            String[] parts1 = log1.split(" ", 2);
            String[] parts2 = log2.split(" ", 2);

            String content1 = parts1[1];
            String content2 = parts2[1];
            
            int contentCompare = content1.compareTo(content2);
            if (contentCompare != 0) {
                return contentCompare;
            }
            
            // 내용이 같을 경우 식별자로 정렬
            return parts1[0].compareTo(parts2[0]);
        });

        // 문자 로그와 숫자 로그 합치기
        letterLogs.addAll(digitLogs);
        
        return letterLogs.toArray(new String[0]);
    }
}