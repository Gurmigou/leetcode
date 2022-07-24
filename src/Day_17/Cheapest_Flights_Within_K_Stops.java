package Day_17;

import java.util.*;

public class Cheapest_Flights_Within_K_Stops {
    public static void main(String[] args) {
        var app = new Cheapest_Flights_Within_K_Stops();

        int[][] flights = {
                new int[]{0, 1, 5},
                new int[]{1, 2, 5},
                new int[]{0, 3, 2},
                new int[]{3, 1, 2},
                new int[]{1, 4, 1},
                new int[]{4, 2, 1}
        };
        int n = 5;
        int src = 0;
        int dst = 2;
        int k = 2;

        int result = app.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result);
    }

    public List<List<int[]>> buildAdjList(int[][] flights, int n) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (var flight : flights) {
            adjList.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        return adjList;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // [to, price]
        List<List<int[]>> adjList = buildAdjList(flights, n);

        // pq of the cheapest price
        var pq = new PriorityQueue<Integer>();
        Queue<int[]> queue = new ArrayDeque<>();
        // [vertex, price, steps]
        queue.add(new int[]{src, 0, 0});
//        var visited = new HashSet<Integer>();

        while (!queue.isEmpty()) {
            var vertex = queue.poll();
//            visited.add(vertex[0]);

            if (vertex[0] == dst) {
                pq.add(vertex[1]);
                continue;
            }

            if (vertex[2] > k)
                continue;

            for (var neighbor : adjList.get(vertex[0])) {
//                if (!visited.contains(neighbor[0])) {
                    queue.add(new int[] {neighbor[0], vertex[1] + neighbor[1], vertex[2] + 1});
//                }
            }
        }

        return pq.isEmpty() ? -1 : pq.poll();
    }
}
