package Summer_Coding.Day_12;

import java.util.HashMap;
import java.util.Map;

public class Longest_Repeating_Character_Replacement {
    public static void main(String[] args) {
        var app = new Longest_Repeating_Character_Replacement();

        String s = "AAAAABBBBCBB";
        int k = 4;

        int result = app.characterReplacement(s, k);
        System.out.println(result);
    }

    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        char curChar = s.charAt(0);
        int longest = 0;

        while (r < s.length()) {
            map.merge(s.charAt(r), 1, Integer::sum);

            if (map.get(s.charAt(r)) > map.get(curChar))
                curChar = s.charAt(r);

            while ((r - l + 1) - map.get(curChar) > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;

                int max = -1;
                char charMax = curChar;
                for (Map.Entry<Character, Integer> e : map.entrySet()) {
                    if (e.getValue() > max) {
                        max = e.getValue();
                        charMax = e.getKey();
                    }
                }
                curChar = charMax;
            }

            longest = Math.max(longest, r - l + 1);
            r++;
        }

        return longest;
    }
}
