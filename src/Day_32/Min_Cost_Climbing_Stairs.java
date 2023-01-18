package Day_32;

import java.util.HashMap;

public class Min_Cost_Climbing_Stairs {
    public static void main(String[] args) {
        var app = new Min_Cost_Climbing_Stairs();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int result = app.minCostClimbingStairs(cost);
        System.out.println(result);
    }

    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
