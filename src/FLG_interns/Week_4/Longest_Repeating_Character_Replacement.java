package FLG_interns.Week_4;

import java.util.HashMap;

public class Longest_Repeating_Character_Replacement {
    public static void main(String[] args) {
        var app = new Longest_Repeating_Character_Replacement();
        app.characterReplacement("ABBB", 2);
    }

    public int characterReplacement(String s, int k) {
        var map = new HashMap<Character, Integer>();
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

                char maxChar = curChar;
                int maxVal = -1;
                for (var entry : map.entrySet()) {
                    if (entry.getValue() > maxVal) {
                        maxVal = entry.getValue();
                        maxChar = entry.getKey();
                    }
                }
                curChar = maxChar;
            }

            longest = Math.max(longest, (r - l + 1));
            r += 1;
        }

        return longest;
    }

    public int characterReplacementFast(String s, int k) {
        int[] map = new int[26];
        int l = 0;
        int r = 0;

        int result = 0;
        int mostInWindow = 0;
        while (r < s.length()) {
            map[s.charAt(r) - 'A'] += 1;
            mostInWindow = Math.max(mostInWindow, map[s.charAt(r) - 'A']);
            if ((r - l + 1) - mostInWindow > k) {
                map[s.charAt(l) - 'A'] -= 1;
                l += 1;
            }
            result = Math.max(result, (r - l + 1));
            r += 1;
        }
        return result;
    }
}














