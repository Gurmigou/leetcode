package Google_online_assessment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Number_of_Good_Ways_to_Split_a_String {
    public int numSplits(String s) {
        int l = 0;
        int r = s.length() - 1;

        var setLeft = new HashSet<Character>();
        var setRight = new HashSet<Character>();
        var mapLeft = new HashMap<Integer, Integer>();
        var mapRight = new HashMap<Integer, Integer>();

        while (r >= 0) {
            setLeft.add(s.charAt(l));
            setRight.add(s.charAt(r));

            mapLeft.put(l, setLeft.size());
            mapRight.put(r, setRight.size());

            l++;
            r--;
        }

        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (Objects.equals(mapLeft.get(i), mapRight.get(i + 1)))
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
        var app = new Number_of_Good_Ways_to_Split_a_String();
        app.numSplitsFast("aacaba");
    }

    public int numSplitsFast(String s) {
        int n = s.length();
        boolean[] leftSet = new boolean[26];
        boolean[] rightSet = new boolean[26];
        int[] leftMap = new int[n];
        int[] rightMap = new int[n];

        char[] chars = s.toCharArray();

        int leftDistinct = 0;
        int rightDistinct = 0;

        for (int i = 0; i < n; i++) {
            if (!leftSet[chars[i] - 'a']) {
                leftDistinct++;
                leftSet[chars[i] - 'a'] = true;
            }
            if (!rightSet[chars[n - i - 1] - 'a']) {
                rightDistinct++;
                rightSet[chars[n - i - 1] - 'a'] = true;
            }

            leftMap[i] = leftDistinct;
            rightMap[n - i - 1] = rightDistinct;
        }

        int counter = 0;
        for (int i = 0; i < n - 1; i++) {
            if (leftMap[i] == rightMap[i + 1])
                counter++;
        }
        return counter;
    }
}
