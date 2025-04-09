class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;

        for (int num : nums) {
            if (num == 0) {
                red++;
            } else if (num == 1) {
                white++;
            } else {
                blue++;
            }
        }

        int p = 0;

        while (red > 0) {
            nums[p++] = 0;
            red--;
        }

        while (white > 0) {
            nums[p++] = 1;
            white--;
        }

        while (blue > 0) {
            nums[p++] = 2;
            blue--;
        }
    }
}