package Day_31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        var app = new Subsets();
        int[] nums = {0};

        var result = app.subsets(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            backtracking(result, new ArrayList<>(), nums, i);
        }

        result.add(Collections.emptyList());
        return result;
    }

    public void backtracking(List<List<Integer>> result, List<Integer> values, int[] nums, int index) {
        var current = new ArrayList<>(values);
        current.add(nums[index]);
        result.add(current);

        for (int i = index + 1; i < nums.length; i++) {
            backtracking(result, current, nums, i);
        }
    }
}
