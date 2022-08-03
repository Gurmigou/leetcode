package Day_28;

import Util.Pair;

import java.util.HashMap;

public class Maximal_Square {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // (row, column) -> max square length
        var cache = new HashMap<Pair<Integer, Integer>, Integer>();

        helper(n, m, 0, 0, cache, matrix);

        int max = 0;
        for (var value : cache.values())
            max = Math.max(max, value);

        return max;
    }

    public int helper(int n, int m, int row, int column, HashMap<Pair<Integer, Integer>, Integer> cache, char[][] matrix) {
        if (row >= n || column >= m)
            return 0;

        var cur = Pair.of(row, column);

        if (!cache.containsKey(cur)) {
            int right = helper(n, m, row, column + 1, cache, matrix);
            int bottom = helper(n, m, row + 1, column, cache, matrix);
            int diagonal = helper(n, m, row + 1, column + 1, cache, matrix);


            cache.put(cur, 0);
            if (matrix[row][column] == '1') {
                cache.put(cur, 1 + Math.min(right, Math.min(bottom, diagonal)));
            }
        }

        return cache.get(cur);
    }
}
