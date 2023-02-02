package OA_2022.TikTok_OA;

public class Plus_One {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] == 9)
                digits[i] = 0;
            else {
                digits[i] += 1;
                break;
            }
            i--;
        }
        if (digits[0] == 0) {
            int[] digitsPlusOne = new int[digits.length + 1];
            digitsPlusOne[0] = 1;
            return digitsPlusOne;
        } else {
            return digits;
        }
    }
}
