package Summer_Coding.Day_28;

public class Minimum_Path_Sum {
    public static void main(String[] args) {
        var app = new Minimum_Path_Sum();

        int[][] grid = new int[][]{new int[]{1, 3, 1}, new int[]{1, 5, 1}, new int[]{4, 2, 1}};
        app.minPathSum(grid);
    }

    public int minPathSum(int[][] grid) {
        final int INF = 1000;

        int n = grid.length;
        int m = grid[0].length;

        int[][] gridSum = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            gridSum[i][m] = INF;
        for (int i = 0; i <= m; i++)
            gridSum[n][i] = INF;

        gridSum[n][m - 1] = 0;

        for (int r = n - 1; r >= 0; r--) {
            for (int c = m - 1; c >= 0; c--) {
                gridSum[r][c] = grid[r][c] + Math.min(gridSum[r + 1][c], gridSum[r][c + 1]);
            }
        }

        return gridSum[0][0];
    }
}
