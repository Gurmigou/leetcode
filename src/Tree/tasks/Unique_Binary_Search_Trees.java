package Tree.tasks;

public class Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int level = 2; level <= n; level++) {
            for (int rootValue = 1; rootValue <= level; rootValue++) {
                int numTreesLeft = dp[rootValue - 1]; // that means that there are (rootValue - 1) values less than rootValue
                int numTreesRight = dp[level - rootValue];
                dp[level] += numTreesLeft * numTreesRight;
            }
        }
        return dp[n];
    }
}
