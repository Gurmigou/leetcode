package Summer_Coding.Day_29;

public class Perfect_Squares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            dp[i] = n + 1;

        dp[0] = 0;

        for (int target = 1; target <= n; target++) {
            for (int s = 1; s <= target; s++) {
                int square = s * s;
                if (target < square)
                    break;

                dp[target] = Math.min(dp[target], 1 + dp[target - square]);
            }
        }

        return dp[n];
    }
}
