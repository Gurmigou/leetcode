package Summer_Coding.Day_10;

import java.util.HashMap;

public class Subarray_Sum_Equals_K {
    public static void main(String[] args) {
        var app = new Subarray_Sum_Equals_K();

        int[] arr = {1, 0, 1, 1, -1, 1, 1};
        int k = 2;

        int result = app.subarraySum(arr, k);
        System.out.println(result);
    }

    // 7 5 10 11 6
    // 2 5 5 1 1

    public int subarraySum(int[] nums, int k) {
        int result = 0;

        // map: prefixSum -> count
        var map = new HashMap<Integer, Integer>();
        // put zero value
        map.put(0, 1);

        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            if (map.containsKey(currentSum - k))
                result += map.get(currentSum - k);

            if (map.containsKey(currentSum))
                map.put(currentSum, map.get(currentSum) + 1);
            else
                map.put(currentSum, 1);
        }

        return result;
    }
}
