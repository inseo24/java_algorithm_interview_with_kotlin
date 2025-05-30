class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 정렬
        Arrays.sort(nums);
        
        // 첫 번째 수를 고정하며 반복
        for (int i = 0; i < nums.length - 2; i++) {
            // 첫 번째 수의 중복 건너뛰기
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            // 투 포인터로 나머지 두 수 찾기
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // 중복된 값 건너뛰기
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    left++;
                    right--;
                    
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;   
    }
}