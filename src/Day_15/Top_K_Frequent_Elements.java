package Day_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
    public static void main(String[] args) {
        var app = new Top_K_Frequent_Elements();

        int[] arr = {1};
        int k = 1;

        int[] ints = app.topKFrequentAlternative(arr, k);
        System.out.println(Arrays.toString(ints));
    }

    public int[] topKFrequent(int[] nums, int k) {
        var count = new HashMap<Integer, Integer>();

        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }

        ArrayList<Integer>[] frequency = new ArrayList[nums.length + 1];

        for (var keyValue : count.entrySet()) {
            if (frequency[keyValue.getValue()] == null)
                frequency[keyValue.getValue()] = new ArrayList<>();

            frequency[keyValue.getValue()].add(keyValue.getKey());
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = frequency.length - 1; i >= 0 && index < result.length; i--) {
            if (frequency[i] != null && !frequency[i].isEmpty()) {
                for (int j = 0; j < frequency[i].size() && index < result.length; j++) {
                    result[index] = frequency[i].get(j);
                    index++;
                }
            }
        }

        return result;
    }

    public int[] topKFrequentAlternative(int[] nums, int k) {
        var count = new HashMap<Integer, Integer>();

        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }

        // int[]:
        // 0: frequency
        // 1: value
        var pr = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[0], a[0]));

        for (var keyValue : count.entrySet()) {
            pr.add(new int[] {keyValue.getValue(), keyValue.getKey()});
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pr.remove()[1];
        }

        return result;
    }
}
