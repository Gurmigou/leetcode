package DynamicProgramming;

public class Maximum_Subarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {5, 4, -1, 7, 8}));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        int result = Integer.MIN_VALUE;
        int index = 1;
        for (int a : nums) {
            dp[index] = Math.max(a, dp[index - 1] + a);
            result = Math.max(result, dp[index]);
            index++;
        }
        return result;
    }
}
