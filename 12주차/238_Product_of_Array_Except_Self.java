class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // ex) [1,2,3,4]
        // 각 위치에서 왼쪽 모든 원소의 곱
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // [1,1,1*2,6(1*2*3)]
        
        // 오른쪽 원소 누적 곱
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        // [1 * 24(2*3*4), 1 * 12(3*4), 2 * 4, 6 * 1]

        return result;
    }
}