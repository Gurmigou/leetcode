package Dailty_Problems.month_1.Day_06_01;

import java.util.Arrays;

public class Maximum_Ice_Cream_Bars {
    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));

    }

    public static int maxIceCream(int[] costs, int coins) {
        // sort costs revert
        Arrays.sort(costs);
        int result = 0;
        for (int cost : costs) {
            if (coins - cost >= 0) {
                result++;
                coins -= cost;
            }
            else
                return result;
        }
        return result;
    }
}
