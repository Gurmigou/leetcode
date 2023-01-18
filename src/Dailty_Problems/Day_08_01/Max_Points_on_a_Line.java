package Dailty_Problems.Day_08_01;

import Util.Fraction;
import Util.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class Max_Points_on_a_Line {
    public int maxPoints(int[][] points) {
        HashMap<Pair<Fraction, Fraction>, HashSet<Pair<Integer, Integer>>> linePointsMap = new HashMap<>();
        int max = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    Pair<Fraction, Fraction> line = getLine(points[i][0], points[i][1], points[j][0], points[j][1]);
                    if (!linePointsMap.containsKey(line)) {
                        linePointsMap.put(line, new HashSet<>());
                    }

                    var set = linePointsMap.get(line);

                    set.add(Pair.of(points[i][0], points[i][1]));
                    set.add(Pair.of(points[j][0], points[j][1]));

                    max = Math.max(max, set.size());
                }
            }
        }

        return max;
    }

    private Pair<Fraction, Fraction> getLine(int x_0, int y_0, int x_1, int y_1) {
        if (x_0 == x_1)
            return Pair.of(Fraction.of(x_0, 1), null);
        if (y_0 == y_1)
            return Pair.of(null, Fraction.of(y_0, 1));

        Fraction slope = Fraction.of((y_1 - y_0), 1).divide(Fraction.of((x_1 - x_0), 1));
        Fraction intercept = Fraction.of(y_0, 1).subtract(slope.multiply(Fraction.of(x_0, 1)));
        return Pair.of(slope, intercept);
    }
}
