package Summer_Coding.Day_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Time_Based_Key_Value_Store {
    private static class Pair {
        String first;
        int second;

        public Pair(String s, int i) {
            this.first = s;
            this.second = i;
        }

        static Pair of(String s, int i) {
            return new Pair(s, i);
        }
    }
    private final HashMap<String, List<Pair>> map;

    public Time_Based_Key_Value_Store() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(Pair.of(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Pair> values = map.get(key);

        if (values == null || values.isEmpty())
            return "";

        int low = 0;
        int high = values.size() - 1;

        String result = "";

        while (low <= high) {
            int middle = (low + high) / 2;
            if (values.get(middle).second <= timestamp) {
                result = values.get(middle).first;
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return result;
    }
}
