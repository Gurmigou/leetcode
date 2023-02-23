package Dailty_Problems.month_1.Day_17_01;

public class Flip_String_to_Monotone_Increasing_Efficient {
    public int minFlipsMonoIncr(String s) {
        int countOne = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                countOne++;
            else
                res = Math.min(res + 1, countOne);
        }
        return res;
    }
}
