import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // 1. start 값을 기준으로 오름차순 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. 병합된 결과를 저장할 리스트
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // 3. 병합된 리스트가 비어 있거나, 현재 구간이 이전 구간과 겹치지 않는 경우 -> 새로운 구간 추가
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // 4. 겹치는 경우, 끝 값을 갱신 (병합 수행)
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // 5. 리스트를 2차원 배열로 변환하여 반환
        return merged.toArray(new int[merged.size()][]);
    }
}
