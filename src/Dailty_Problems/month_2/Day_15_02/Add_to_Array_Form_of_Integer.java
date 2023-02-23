package Dailty_Problems.month_2.Day_15_02;

import java.util.LinkedList;
import java.util.List;

public class Add_to_Array_Form_of_Integer {
    public static void main(String[] args) {
        var app = new Add_to_Array_Form_of_Integer();
        app.addToArrayForm(new int[] {2, 7, 4}, 181);
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        int remainder = 0;
        var result = new LinkedList<Integer>();
        for (int i = num.length - 1; i >= 0; i--) {
            int digit = num[i] + (k % 10) + remainder;
            remainder = 0;
            if (digit > 9) {
                digit = digit - 10;
                remainder += 1;
            }
            result.addFirst(digit);
            k /= 10;
        }
        while (k != 0) {
            int digit = (k % 10) + remainder;
            remainder = 0;
            if (digit > 9) {
                digit = digit - 10;
                remainder += 1;
            }
            result.addFirst(digit);
            k /= 10;
        }
        if (remainder != 0)
            result.addFirst(remainder);
        return result;
    }
}
