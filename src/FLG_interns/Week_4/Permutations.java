package FLG_interns.Week_4;

import java.util.ArrayList;
import java.util.List;

// Leetcode task 46
public class Permutations {
    public static void main(String[] args) {
        var app = new Permutations();
        app.permute(new int[] {1, 2, 3});
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int num : nums) {
            List<Integer> subResult = new ArrayList<>();
            subResult.add(num);
            backtrack(subResult, nums, result);
        }
        return result;

    }

    void backtrack(List<Integer> subResult, int[] arr, List<List<Integer>> result) {
        if (subResult.size() == arr.length) {
            result.add(subResult);
            return;
        }

         for (int num : arr) {
            if (!subResult.contains(num)) {
                List<Integer> next = new ArrayList<>(subResult);
                next.add(num);
                backtrack(next, arr, result);
            }
        }
    }

}
