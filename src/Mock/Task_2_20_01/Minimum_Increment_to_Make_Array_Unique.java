package Mock.Task_2_20_01;

import java.util.Arrays;

public class Minimum_Increment_to_Make_Array_Unique {
    public static void main(String[] args) {
        var app = new Minimum_Increment_to_Make_Array_Unique();
        app.minIncrementForUnique2(new int[] {1, 2, 2, 2, 2, 3});
    }

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            int expect = prev + 1;
            if (nums[i] < expect) {
                result += expect - nums[i];
                prev = expect;
            } else {
                prev = nums[i];
            }
        }
        return result;
    }

    public int minIncrementForUnique2(int[] nums) {
        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }

        int[] count = new int[nums.length + maxVal];
        for (int x : nums) {
            count[x]++;
        }

        int moves = 0;
        int taken = 0;
        for (int x = 0; x < nums.length + maxVal; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                moves -= x * (count[x] - 1);
            } else if (taken > 0 && count[x] == 0) {
                taken--;
                moves += x;
            }
        }

        return moves;    }
}
