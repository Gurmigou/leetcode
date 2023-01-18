package Dailty_Problems.Day_13_01;

import java.util.ArrayList;
import java.util.List;

public class Longest_Path_With_Different_Adjacent_Characters {
    private int answer = 0;

    public int longestPath(int[] parent, String s) {
        var adjList = createAdjList(parent);
        dfs(adjList, s, 0);
        return answer;
    }

    private int dfs(List<Integer>[] adjList, String s, int node) {
        int longest = 0, secondLongest = 0;

        for (var neighbour : adjList[node]) {
            int length = dfs(adjList, s, neighbour);

            if (s.charAt(node) != s.charAt(neighbour)) {
                if (length > longest) {
                    secondLongest = longest;
                    longest = length;
                } else if (length > secondLongest) {
                    secondLongest = length;
                }
            }
        }

        answer = Math.max(answer, longest + secondLongest + 1);
        return longest + 1;
    }

    private List<Integer>[] createAdjList(int[] parent) {
        int n = parent.length;
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int i = 1; i < n; ++i)
            graph[parent[i]].add(i);
        return graph;
    }
}
