package Day_3;

public class Search_a_2D_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11,16, 20},
                {23, 30, 34, 60}
        };

        int target = 3;

        var app = new Search_a_2D_Matrix();
        app.searchMatrix(matrix, target);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;

        int targetRow = 0;

        while (low <= high) {
            int middle = (low + high) / 2;

            int lastRowValue = matrix[middle][matrix[middle].length - 1];

            if (target <= lastRowValue) {
                targetRow = middle;
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        int[] arr = matrix[targetRow];
        low = 0;
        high = arr.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (arr[middle] == target)
                return true;
            if (arr[middle] < target)
                low = middle + 1;
            else
                high = middle - 1;
        }

        return false;
    }
}
