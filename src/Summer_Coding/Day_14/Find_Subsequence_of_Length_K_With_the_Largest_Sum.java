package Summer_Coding.Day_14;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Find_Subsequence_of_Length_K_With_the_Largest_Sum {
    public int[] maxSubsequence(int[] nums, int k) {
        // int[]
        // 0: value
        // 1: index
        var pr = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[0], a[0]));

        int index = 0;
        for (int num : nums) {
            pr.add(new int[]{num, index++});
        }

        var list = new ArrayList<int[]>();

        for (int i = 0; i < k; i++) {
            list.add(pr.remove());
        }

        return list
                .stream()
                .sorted((a, b) -> Integer.compare(a[1], b[1]))
                .mapToInt(arr -> arr[0])
                .toArray();
    }
}
