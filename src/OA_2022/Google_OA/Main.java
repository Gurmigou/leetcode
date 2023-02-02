package OA_2022.Google_OA;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var r = getUniqueCharacter("hackthegame");
        System.out.println(r);
    }

    public static int getUniqueCharacter(String s) {
        int[][] memo = new int[26][2];

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int[] curMemo = memo[cur - 'a'];
            if (curMemo[0] == 0) {
                curMemo[0] = 1;
                curMemo[1] = i;
            } else {
                curMemo[0] = curMemo[0] + 1;
            }
        }

        // min index
        int result = Integer.MAX_VALUE;

        for (int[] m : memo) {
            if (m[0] == 1) {
                result = Math.min(result, m[1]);
            }
        }

        return result + 1;
    }

    public static List<Integer> hasVowels(List<String> strArr, List<String> query) {
        int[] prefixSum = new int[strArr.size() + 1];

        int index = 1;
        for (String str : strArr) {
            char first = str.charAt(0);
            char second = str.charAt(str.length() - 1);
            if (isVowel(first) && isVowel(second)) {
                prefixSum[index] = prefixSum[index - 1] + 1;
            } else {
                prefixSum[index] = prefixSum[index - 1];
            }
            index++;
        }

        List<Integer> result = new ArrayList<>();
        for (String q : query) {
            String[] split = q.split("-");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);

            result.add(prefixSum[end] - prefixSum[start - 1]);
        }


        return result;
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

}
