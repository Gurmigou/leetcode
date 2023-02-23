package Dailty_Problems.month_1.Day_12_01;

import java.util.*;

public class Number_of_Nodes_in_the_Sub_Tree_With_the_Same_Label {
    public static void main(String[] args) {
        var app = new Number_of_Nodes_in_the_Sub_Tree_With_the_Same_Label();
        int[] result = app.countSubTrees(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, "abaedcd");
        System.out.println(Arrays.toString(result));
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        var adjList = createAdjList(n, edges);
        int[] result = new int[n];

        dfs(adjList, 0, 0, labels, result);
        return result;
    }

    private int[] dfs(List<Integer>[] adjList, int vertex, int prevVertex, String labels, int[] result) {
        int[] currentValues = new int[26];

        for (var neighbour : adjList[vertex]) {
            if (neighbour != prevVertex) {
                int[] childValues = dfs(adjList, neighbour, vertex, labels, result);
                for (int i = 0; i < 26; i++)
                    currentValues[i] += childValues[i];
            }
        }

        var curChar = labels.charAt(vertex);
        currentValues[curChar - 'a'] += 1;
        result[vertex] = currentValues[curChar - 'a'];
        return currentValues;
    }

    private List<Integer>[] createAdjList(int n, int[][] edges) {
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
