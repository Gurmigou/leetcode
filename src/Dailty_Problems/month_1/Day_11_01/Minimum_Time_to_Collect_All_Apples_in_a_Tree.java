package Dailty_Problems.month_1.Day_11_01;

import java.util.ArrayList;
import java.util.List;

public class Minimum_Time_to_Collect_All_Apples_in_a_Tree {
    public static void main(String[] args) {
        var app = new Minimum_Time_to_Collect_All_Apples_in_a_Tree();

        var arr = new int[][]{{0, 2}, {0, 3}, {1, 2}};

        System.out.println(app.minTime(4, arr, List.of(false, true, false, false)));
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        var adjList = createAdjList(n, edges);

        boolean[] visited = new boolean[n];

        int steps = dfs(adjList, 0, hasApple, visited);
        return steps == 0 ? 0 : steps - 2;
    }

    private static int dfs(List<Integer>[] adjList, int vertex, List<Boolean> hasApple, boolean[] visited) {
        int result = 0;
        visited[vertex] = true;

        for (var neighbour : adjList[vertex]) {
            if (!visited[neighbour])
                result += dfs(adjList, neighbour, hasApple, visited);
        }

        if (hasApple.get(vertex) || result != 0)
            result += 2;

        return result;
    }

    private static List<Integer>[] createAdjList(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (var pair : edges) {
            adjList[pair[0]].add(pair[1]);
            adjList[pair[1]].add(pair[0]);
        }
        return adjList;
    }
}
