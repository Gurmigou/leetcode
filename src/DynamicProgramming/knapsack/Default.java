package DynamicProgramming.knapsack;

import java.util.HashSet;

public class Default {
    public static void main(String[] args) {
        Default ks = new Default();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsackDefault(profits, weights, 7);
        System.out.println("Total knapsack profit default ---> " + maxProfit);
        maxProfit = ks.solveKnapsackDefault(profits, weights, 6);
        System.out.println("Total knapsack profit default ---> " + maxProfit);

        maxProfit = ks.solveKnapsackTopDownWithMemo(profits, weights, 7);
        System.out.println("Total knapsack profit top-down with memo ---> " + maxProfit);
        maxProfit = ks.solveKnapsackTopDownWithMemo(profits, weights, 6);
        System.out.println("Total knapsack profit top-down with memo ---> " + maxProfit);
    }

    // Default approach: O(2^N)
    public int solveKnapsackDefault(int[] profits, int[] weights, int capacity) {
        return solveKnapsackHelperDefault(profits, weights, capacity, 0, 0, 0);
    }

    public int solveKnapsackHelperDefault(int[] profits, int[] weights, int capacity, int curWeight, int curProfit, int curItemIndex) {
        if (curWeight > capacity)
            return -1;
        if (curItemIndex >= profits.length)
            return curProfit;

        return Math.max(
                solveKnapsackHelperDefault(profits, weights, capacity, curWeight + weights[curItemIndex], curProfit + profits[curItemIndex], curItemIndex + 1),
                solveKnapsackHelperDefault(profits, weights, capacity, curWeight, curProfit, curItemIndex + 1)
        );
    }

    // Top-down approach with memo: O(N * C), where C - knapsack capacity, N - number of items
    public int solveKnapsackTopDownWithMemo(int[] profits, int[] weights, int capacity) {
        int[][] memo = new int[profits.length][capacity + 1];
        return solveKnapsackHelperTopDownWithMemo(profits, weights, capacity, 0,  memo);
    }

    static int solution(Integer[] loads) {
        HashSet<Integer> variants = new HashSet<>();
        bruteForce(variants, loads, 0, 0);

        int sum = 0;
        for (Integer a : loads)
            sum += a;

        int min = Integer.MAX_VALUE;
        for (Integer a : variants) {
            min = Math.min(min, Math.abs(a - (sum - a)));
        }

        return min;
    }

    static void bruteForce(HashSet<Integer> variants, Integer[] loads, int currentValue, int index) {
        if (index == loads.length) {
            variants.add(currentValue);
            return;
        }
        bruteForce(variants, loads, currentValue + 0, index);
        bruteForce(variants, loads, currentValue + loads[index], index);
    }

    public int solveKnapsackHelperTopDownWithMemo(int[] profits, int[] weights, int curWeight, int curItemIndex, int[][] memo) {
        if (curWeight <= 0 || curItemIndex >= profits.length)
            return 0;
        if (memo[curItemIndex][curWeight] != 0)
            return memo[curItemIndex][curWeight];

        int profit1 = 0;
        if (weights[curItemIndex] <= curWeight) {
            profit1 = profits[curItemIndex] + solveKnapsackHelperTopDownWithMemo(profits, weights,
                    curWeight - weights[curItemIndex], curItemIndex + 1, memo);
        }
        int profit2 = solveKnapsackHelperTopDownWithMemo(profits, weights, curWeight, curItemIndex + 1, memo);
        System.out.println("profit1: " + profit1 + ", profit2: " + profit2);

        memo[curItemIndex][curWeight] = Math.max(profit1, profit2);
        return memo[curItemIndex][curWeight];
    }

    public int solveKnapsackBottomUp(int[] profits, int[] weights, int capacity) {
        int[][] memo = new int[profits.length][capacity + 1];
        return solveKnapsackHelperTopDownWithMemo(profits, weights, capacity, 0,  memo);
    }
//
//    public int solveKnapsackHelperBottomUp(int[] profits, int[] weights, int curWeight, int curItemIndex, int[][] memo) {
//
//    }
}
