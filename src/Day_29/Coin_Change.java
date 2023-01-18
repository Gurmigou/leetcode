package Day_29;

public class Coin_Change {
    public static void main(String[] args) {
        var app = new Coin_Change();

        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = app.coinChange(coins, amount);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++)
            dp[i] = amount + 1;

        dp[0] = 0;

        for (int target = 1; target <= amount; target++) {
            for (int coin : coins) {
                if (coin > target)
                    break;

                dp[target] = Math.min(dp[target], 1 + dp[target - coin]);
            }
        }

        // unreachable
        if (dp[amount] == amount + 1)
            return -1;

        return dp[amount];
    }
}
