package Day_15;

import java.util.Arrays;
import java.util.PriorityQueue;

public class K_Closest_Points_to_Origin {
    public static void main(String[] args) {
        var app = new K_Closest_Points_to_Origin();

        int[][] points = {new int[]{3, 3}, new int[]{5, -1}, new int[]{-2, 4}};
        int k = 2;

        int[][] ints = app.kClosest(points, k);
        System.out.println(Arrays.deepToString(ints));
    }

    static class Pair {
        int distance;
        int[] point;

        public Pair(int distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }

        static Pair of(int distance, int[] point) {
            return new Pair(distance, point);
        }
    }

    public int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        var pr = new PriorityQueue<Pair>((a, b) -> Integer.compare(a.distance, b.distance));

        for (int[] point : points) {
            pr.add(Pair.of(distance(point), point));
        }

        int[][] result = new int[k][];

        for (int i = 0; i < k; i++) {
            result[i] = pr.remove().point;
        }

        return result;
    }
}
