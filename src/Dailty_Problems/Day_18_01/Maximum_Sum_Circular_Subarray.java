package Dailty_Problems.Day_18_01;

import java.util.Arrays;

public class Maximum_Sum_Circular_Subarray {
    public static void main(String[] args) {
        productExceptSelf(new int[] {1, 2, 3, 4});
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int curMax = nums[0];
        int globalMax = curMax;

        int curMin = curMax;
        int globalMin = curMax;

        int totalSum = curMax;

        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];

            curMax = Math.max(curMax + nums[i], nums[i]);
            globalMax = Math.max(globalMax, curMax);

            curMin = Math.min(curMin + nums[i], nums[i]);
            globalMin = Math.min(globalMin, curMin);
        }

        if (globalMax < 0)
            return globalMax;

        return Math.max(globalMax, totalSum - globalMin);
    }
}
