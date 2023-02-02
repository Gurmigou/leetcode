package Summer_Coding.Day_4;

public class Split_Array_Largest_Sum {
    public int splitArray(int[] nums, int m) {
        // left = max(nums)
        // right = sum(nums)
        int left = 0, right = 0;
        for (int a : nums) {
            left = Math.max(left, a);
            right += a;
        }

        int minimumLargestSum = Integer.MAX_VALUE;

        // Our result is in [left, right]
        // Using binary search find minimum largest sum
        while (left <= right) {
            int supposeLargestSum = left + ((right - left) / 2);

            if (canSplit(nums, supposeLargestSum, m)) {
                minimumLargestSum = supposeLargestSum;
                right = supposeLargestSum - 1;
            } else {
                left = supposeLargestSum + 1;
            }
        }

        return minimumLargestSum;
    }

    private boolean canSplit(int[] nums, int supposeLargestSum, int m) {
        int numSubArrays = 0;
        int largestSum = 0;

        for (int n : nums) {
            largestSum += n;
            if (largestSum > supposeLargestSum) {
                numSubArrays += 1;
                largestSum = n;
            }
        }

        return (numSubArrays + 1) <= m;
    }
}
