package Summer_Coding.Day_16;

import Util.Pair;

import java.util.List;
import java.util.PriorityQueue;

public class Longest_Happy_String {
    public static void main(String[] args) {
        var app = new Longest_Happy_String();

        String result = app.longestDiverseString(7, 1, 0);
        System.out.println(result);
    }

    public String longestDiverseString(int a, int b, int c) {
        var result = new StringBuilder();
        var pq = new PriorityQueue<Pair<Character, Integer>>((p1, p2) -> Integer.compare(p2.second, p1.second));

        for (var pair : List.of(Pair.of('a', a), Pair.of('b', b), Pair.of('c', c)))
            if (pair.second != 0)
                pq.add(pair);

        while (!pq.isEmpty()) {
            Pair<Character, Integer> top = pq.poll();

            if (result.length() > 1 && result.charAt(result.length() - 1) == top.first && result.charAt(result.length() -2) == top.first) {
                Pair<Character, Integer> top2 = pq.poll();

                if (top2 == null)
                    break;
                else {
                    top2.second--;
                    result.append(top2.first);
                }

                if (top2.second != 0)
                    pq.add(top2);
            } else {
                result.append(top.first);
                top.second--;
            }

            if (top.second != 0)
                pq.add(top);
        }

        return result.toString();
    }
}
