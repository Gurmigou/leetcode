package Dailty_Problems.month_1.Day_17_01;

import java.util.HashMap;
import java.util.Objects;

public class Flip_String_to_Monotone_Increasing {
    public int minFlipsMonoIncr(String s) {
        HashMap<Pair<Integer, Boolean>, Integer> memo = new HashMap<>();

        memo.put(Pair.of(s.length(), true), 0);
        memo.put(Pair.of(s.length(), false), 0);

        return traverseString(s, 0, true, memo);
    }

    private int traverseString(String s, int i, boolean onlyZeros, HashMap<Pair<Integer, Boolean>, Integer> memo) {
        var pair = Pair.of(i, onlyZeros);
        if (memo.containsKey(pair))
            return memo.get(pair);

        var cur = s.charAt(i);

        // Only zeros and s[i] == 1
        if (onlyZeros && cur == '1') {
            memo.put(Pair.of(i, true),
                    Math.min(traverseString(s, i + 1, false, memo),
                            1 + traverseString(s, i + 1, true, memo))
            );
        }
        // Only zeros and s[i] == 0
        else if (onlyZeros && cur == '0') {
            memo.put(Pair.of(i, true),
                    Math.min(traverseString(s, i + 1, true, memo),
                            1 + traverseString(s, i + 1, false, memo))
            );
        }
        // NOT only zeros and s[i] == 1
        else if(!onlyZeros && cur == '1') {
            memo.put(Pair.of(i, false), traverseString(s, i + 1, false, memo));
        }
        // NOT only zeros and s[i] == 0
        else {
            memo.put(Pair.of(i, false), 1 + traverseString(s, i + 1, false, memo));
        }

        return memo.get(pair);
    }

    static class Pair<T, V> {
        public T first;
        public V second;

        private Pair(T first, V second) {
            this.first = first;
            this.second = second;
        }

        public static <T, V> Pair<T, V> of(T first, V second) {
            return new Pair<>(first, second);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
