package Course.Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // case of duplication of i-th element
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int l = i + 1;
            int r = nums.length - 1;
            int target = -nums[i];

            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    l++;

                    while (l < r && nums[l] == nums[l - 1])
                        l++;

                    continue;
                }

                if (sum > target)
                    r--;
                else
                    l++;
            }
        }

        return result;
    }
}
