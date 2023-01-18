package Google_online_assessment;

import java.util.Arrays;

public class Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves {
    public int minDifference(int[] nums) {
        if (nums.length <= 4)
            return 0;

        int n = nums.length;
        Arrays.sort(nums);
        return Math.min(
                Math.min(nums[n - 2] - nums[2], nums[n - 3] - nums[1]),
                Math.min(nums[n - 4] - nums[0], nums[n - 1] - nums[3])
        );
    }
}
