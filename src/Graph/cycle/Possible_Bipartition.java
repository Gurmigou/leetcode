package Graph.cycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Possible_Bipartition {
    public static void main(String[] args) {
        var arr = new int[][]{{4, 7}, {4, 8}, {5, 6}, {1, 6}, {3, 7}, {2, 5}, {5, 8}, {1, 2}, {4, 9}, {6, 10}, {8, 10}, {3, 6}, {2, 10}, {9, 10}, {3, 9}, {2, 3}, {1, 9}, {4, 6}, {5, 7}, {3, 8}, {1, 8}, {1, 7}, {2, 4}};
        System.out.println(new Possible_Bipartition().possibleBipartition(10, arr));
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adjList = createAdjList(n, dislikes);
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (canNOTBipartitionDfs(adjList, colors, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean canNOTBipartitionDfs(List<List<Integer>> adjList, int[] colors, int node, int color) {
        colors[node] = color;
        for (Integer neighbour : adjList.get(node)) {
            if (colors[neighbour] == -1) {
                if (canNOTBipartitionDfs(adjList, colors, neighbour, 1 - color))
                    return true;
            }
            if (colors[neighbour] == color)
                return true;
        }
        return false;
    }

    private List<List<Integer>> createAdjList(int n, int[][] dislikes) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] d : dislikes) {
            adjList.get(d[0] - 1).add(d[1] - 1);
            adjList.get(d[1] - 1).add(d[0] - 1);
        }
        return adjList;
    }

    private void dfsDirectedGraph(List<List<Integer>> adjList, int node, int parent, int destination, boolean[] visited) {
        if (node == destination) {
            System.out.println("Found");
            return;
        }
        visited[node] = true;
        for (Integer neighbour : adjList.get(node)) {
            if (neighbour != parent) {
                dfsDirectedGraph(adjList, neighbour, node, destination, visited);
            }
        }

    }
}