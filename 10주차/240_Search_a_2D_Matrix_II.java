public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        
        int column = matrix[0].length - 1;
        int row = 0;

        while(column >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][column]) {
                return true;
            } else if (target < matrix[row][column]) {
                column--;
            } else if (target > matrix[row][column]) {
                row++;
            }
        }

        return false;
    }
}