package Summer_Coding.Day_18;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort_Characters_By_Frequency {
    public String frequencySort(String s) {
        var counter = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for (char c : chars)
            counter.merge(c, 1, Integer::sum);

        var pq = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        pq.addAll(counter.entrySet());

        var result = new StringBuilder();
        while (!pq.isEmpty()) {
            var pair = pq.poll();
            result.append(String.valueOf(pair.getKey()).repeat(Math.max(0, pair.getValue())));
        }
        return result.toString();
    }
}
