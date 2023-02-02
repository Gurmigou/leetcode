package Summer_Coding.Day_32;

public class Two_Keys_Keyboard {
    public static void main(String[] args) {
        var app = new Two_Keys_Keyboard();
        int result = app.minSteps(6);
        System.out.println(result);
    }

    public int minSteps(int n) {
        int[] dp = new int[n + 1];

        for (int k = 2; k <= n; k++) {
            dp[k] = 1001;

            for (int i = 1; i < k; i++) {
                if (k % i != 0)
                    continue;

                // k / i is number of steps to get from i number to k
                // (k - i) / i (PASTE operations) + 1 (COPY operations) = k / i - 1 + 1 = k / i;
                dp[k] = Math.min(dp[k], dp[i] + k / i);
            }
        }

        return dp[n];
    }
}
