package Summer_Coding.Day_25;

public class Minimum_Value_to_Get_Positive_Step_by_Step_Sum {
    public int minStartValue(int[] nums) {
        int minPrefixSum = nums[0];
        int prefixSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum += nums[i];
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
        }
        if (minPrefixSum >= 1)
            return 1;
        return Math.abs(1 - minPrefixSum);
    }
}
