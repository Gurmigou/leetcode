package Other_Topics.DynamicProgramming;

import java.util.Arrays;

public class Coin_Change_Bottom_up_DP {
    public int coinChange(int[] coins, int amount) {
        int[] minDp = new int[amount + 1];
        Arrays.fill(minDp, (amount + 1));
        minDp[0] = 0;
        for (int target = 1; target <= amount; target++) {
            for (int coin : coins) {
                if (coin <= target) {
                    minDp[target] = Math.min(minDp[target], 1 + minDp[target - coin]);
                }
            }
        }
        return minDp[amount] == Integer.MAX_VALUE ? -1 : minDp[amount];
    }
}
