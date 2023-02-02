package Summer_Coding.Day_21;

public class Word_Search {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && backtracking(board, i, j, word, 0, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length())
            return true;

        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (backtracking(board, i - 1, j, word, index + 1, visited) ||
            backtracking(board, i + 1, j, word, index + 1, visited) ||
            backtracking(board, i, j - 1, word, index + 1, visited) ||
            backtracking(board, i, j + 1, word, index + 1, visited)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
