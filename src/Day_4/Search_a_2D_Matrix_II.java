package Day_4;

public class Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            if (target < matrix[i][j])
                j--;
            else
                i++;
        }

        return false;
    }
}
