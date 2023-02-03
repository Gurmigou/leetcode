package Other_Topics.Monotonic_Queue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Jump_Game_VI {
    public static void main(String[] args) {
//        [1,-1,-2,4,-7,3]
        var app = new Jump_Game_VI();
        app.maxResult1(new int[] {1,-5,-20,4,-1,3,-6,-3}, 2);
    }

    /**
     * Dynamic Programming solution with primitive searching of max element in subarray [i - k, i)
     */
    public int maxResult(int[] nums, int k) {
        // i-th position is the max value to jump to this position
        int[] dp = new int[nums.length];
        Arrays.fill(dp, (int) Math.pow(-10, 5));

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int maxJump = maxInInterval(i - k, i, dp);
            dp[i] = nums[i] + maxJump;
        }
        return dp[nums.length - 1];
    }

    private int maxInInterval(int start, int end, int[] array) {
        if (start < 0)
            start = 0;
        int max = array[start];
        for (int i = start + 1; i < end; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Using monotonic queue
     */
    public int maxResult1(int[] nums, int k) {
        // [value, index]
        var monotonicQueue = new ArrayDeque<int[]>();
        monotonicQueue.addLast(new int[] {nums[0], 0});
        for (int i = 1; i < nums.length; i++) {
            if (monotonicQueue.peekFirst()[1] < i - k) {
                monotonicQueue.pollFirst();
            }
            int score = monotonicQueue.peekFirst()[0] + nums[i];
            while (!monotonicQueue.isEmpty() && monotonicQueue.peekLast()[0] < score)
                monotonicQueue.pollLast();
            monotonicQueue.addLast(new int[] {score, i});
        }
        return monotonicQueue.peekLast()[0];
    }
}
























