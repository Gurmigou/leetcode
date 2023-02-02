package Summer_Coding.Day_26;

import java.util.HashMap;

public class Contiguous_Array {
    public static void main(String[] args) {
        var app = new Contiguous_Array();

        int[] arr = {0, 0, 1};

        int result = app.findMaxLength(arr);
        System.out.println(result);
    }

    public int findMaxLengthBruteForce(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int localMax = 0;

            int zeros = 0;
            int ones = 0;

            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0)
                    zeros++;
                else
                    ones++;
                if (zeros == ones)
                    localMax = Math.max(localMax, zeros * 2);
            }

            result = Math.max(result, localMax);
        }

        return result;
    }

    // Количество 0 и 1 между елементами с одинаковым count равное
    public int findMaxLength(int[] nums) {
        var countIndexMap = new HashMap<Integer, Integer>();
        countIndexMap.put(0, -1);
        int result = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count--;
            else
                count++;

            if (countIndexMap.containsKey(count))
                result = Math.max(result, i - countIndexMap.get(count));
            else
                countIndexMap.put(count, i);
        }

        return result;
    }
}
