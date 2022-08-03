package Day_23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams {
    public static void main(String[] args) {
        var app = new Group_Anagrams();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> lists = app.groupAnagrams(strs);
        System.out.println(lists);
    }

    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 107};

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] counter = new int[26];
            for (char ch : s.toCharArray())
                ++counter[ch - 'a'];
            var sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (sb.length() == s.length())
                    break;
                if (counter[i] != 0) {
                    for (int j = 0; j < counter[i]; j++) {
                        sb.append((char) ('a' + i));
                    }
                }
            }
            String key = new String(sb);

            if (!map.containsKey(key)) {
                var list = new ArrayList<String>();
                list.add(s);
                map.put(key, list);
            } else {
                map.get(key).add(s);
            }
        }

        return new ArrayList<>(map.values());
    }
}

