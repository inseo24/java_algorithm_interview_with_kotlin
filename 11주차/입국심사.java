// https://school.programmers.co.kr/learn/courses/30/lessons/43238import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        
        long answer = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long totalPeople = 0;
            
            for (int time : times) {
                totalPeople += mid / time;
                if (totalPeople >= n) break;
            }
            
            if (totalPeople >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}