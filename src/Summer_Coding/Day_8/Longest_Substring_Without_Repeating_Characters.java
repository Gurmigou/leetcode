package Summer_Coding.Day_8;

import java.util.HashSet;

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        var set = new HashSet<Character>();

        int l = 0;
        int result = 0;

        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            result = Math.max(result, r - l + 1);
            set.add(s.charAt(r));
        }

        return result;
    }
}
