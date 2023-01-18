package Day_31;

import java.util.Arrays;

public class Partition_to_K_Equal_Sum_Subsets {
    public static void main(String[] args) {
        var app = new Partition_to_K_Equal_Sum_Subsets();

        int[] arr = {2, 9, 4, 7, 3, 2, 10, 5, 3, 6, 6, 2, 7, 5, 2, 4};
        int k = 7;

        boolean result = app.canPartitionKSubsets(arr, k);
        System.out.println(result);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums)
            sum += n;

        if (sum % k != 0 || nums.length < k)
            return false;

        Arrays.sort(nums);

        return backtracking(nums, nums.length - 1, sum / k, new int[k]);
    }

    public boolean backtracking(int[] nums, int index, int targetSum, int[] buckets) {
        if (index == -1)
            return true;

        for (int b = 0; b < buckets.length; b++) {
            if (buckets[b] + nums[index] <= targetSum) {

                buckets[b] += nums[index];

                if (backtracking(nums, index - 1, targetSum, buckets))
                    return true;

                buckets[b] -= nums[index];
            }

            // ???
            if (buckets[b] == 0)
                break;
        }

        return false;
    }
}





























