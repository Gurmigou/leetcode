package Summer_Coding.Day_9;

import java.util.*;

public class Find_All_Anagrams_in_a_String {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";

        var app = new Find_All_Anagrams_in_a_String();
        List<Integer> result = app.findAnagrams(s, p);

        System.out.println(result);
    }
    public static boolean areEqual(HashMap<Character, Integer> required, HashMap<Character, Integer> other) {
        Set<Map.Entry<Character, Integer>> requiredEntries = required.entrySet();
        for (var entry : requiredEntries) {
            Integer otherValue = other.get(entry.getKey());
            if (otherValue == null || otherValue < entry.getValue())
                return false;
        }
        return true;
    }

    public static void put(HashMap<Character, Integer> map, Character ch) {
        if (map.containsKey(ch))
            map.put(ch, map.get(ch) + 1);
        else
            map.put(ch, 1);
    }

    public static void remove(HashMap<Character, Integer> map, Character ch) {
        Integer count = map.get(ch);
        if (count == null)
            return;
        if (count == 0)
            map.remove(ch);
        else {
            map.put(ch, count - 1);
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length())
            return List.of();

        var sMap = new HashMap<Character, Integer>();
        var pMap = new HashMap<Character, Integer>();

        for (int i = 0; i < p.length(); i++) {
            put(sMap, s.charAt(i));
            put(pMap, p.charAt(i));
        }

        List<Integer> result = new ArrayList<>();

        if (areEqual(pMap, sMap))
            result.add(0);

        int l = 0;

        for (int r = p.length(); r < s.length(); r++) {
            remove(sMap, s.charAt(l));
            l++;
            put(sMap, s.charAt(r));

            if (areEqual(pMap, sMap))
                result.add(l);
        }

        return result;
    }
}
