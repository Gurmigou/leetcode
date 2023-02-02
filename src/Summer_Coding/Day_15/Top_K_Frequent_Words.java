package Summer_Coding.Day_15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Top_K_Frequent_Words {
    public static void main(String[] args) {
        var app = new Top_K_Frequent_Words();

        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;

        List<String> strings = app.topKFrequent(words, k);
        System.out.println(strings);
    }

    public List<String> topKFrequent(String[] words, int k) {
        var count = new HashMap<String, Integer>();

        for (String s : words) {
            count.merge(s, 1, Integer::sum);
        }

        var pr = new PriorityQueue<Pair>((a, b) -> {
            int frequencyComp = Integer.compare(b.second, a.second);
            return frequencyComp == 0 ? a.first.compareTo(b.first) : frequencyComp;
        });

        for (var keyValue : count.entrySet()) {
            pr.add(Pair.of(keyValue.getKey(), keyValue.getValue()));
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(pr.remove().first);
        }

        return result;
    }
}
