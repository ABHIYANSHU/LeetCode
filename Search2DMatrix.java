package LeetCode;

public class Search2DMatrix {

    /**
     * Time Complexity: O(log(m + n))
     * Space Complexity: O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
     * Memory Usage: 42.9 MB, less than 28.53% of Java online submissions for Search a 2D Matrix.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int i, j;
        i = 0;
        j = matrix[0].length - 1;
        
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                j--;
            else
                i++;
        }
            
        return false;
    }
}