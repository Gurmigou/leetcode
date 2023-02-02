package OA_2022.Google_OA;

import java.util.Arrays;
import java.util.List;

public class Task_1 {
    public static void main(String[] args) {
        String s = "[section]-[tab]-[field]";

        // split s to have section, tab, field
        List<String> list = Arrays.stream(s.split("-"))
                .map(str -> str.replaceAll("\\[", "").replaceAll("]", ""))
                .toList();

        System.out.println(list);
    }

    public static int solution(String S) {
        char[] chars = S.toCharArray();

        int result = 0;
        if (chars[0] == 'b')
            result += 1;
        if (chars[0] == 'c')
            result += 2;

        char prev = chars[0];

        for (int i = 1; i < chars.length; i++) {
            char cur = chars[i];
            if (prev == 'a') {
                if (cur == 'a') {
                    result += 2;
                } else if (cur == 'c') {
                    result += 1;
                }
            } else if (prev == 'b') {
                if (cur == 'a') {
                    result += 1;
                } else if (cur == 'b') {
                    result += 2;
                }
            } else {
                if (cur == 'b') {
                    result += 1;
                } else if (cur == 'c') {
                    result += 2;
                }
            }
            prev = cur;
        }
        return result;
    }
}
