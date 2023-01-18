package Graph.dfs;

public class Number_of_Islands {
    public static void main(String[] args) {
        var app = new Number_of_Islands();
        char[][] matrix = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        app.numIslands(matrix);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfsHelper(grid, i, j, n, m);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfsHelper(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
            return;

        grid[i][j] = '0';

        dfsHelper(grid, i - 1, j, n, m);
        dfsHelper(grid, i + 1, j, n, m);
        dfsHelper(grid, i, j - 1, n, m);
        dfsHelper(grid, i, j + 1, n, m);
    }
}
