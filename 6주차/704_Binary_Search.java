class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    
    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2; // 오버플로우 방지
        
        if (nums[mid] == target) {
            return mid; // target을 찾았을 때
        } else if (nums[mid] > target) {
            return binarySearch(nums, left, mid - 1, target); // 왼쪽 반에서 검색
        } else {
            return binarySearch(nums, mid + 1, right, target); // 오른쪽 반에서 검색
        }
    }
}