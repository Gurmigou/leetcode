package Summer_Coding.Day_9;

import java.util.HashMap;

public class Count_Number_of_Nice_Subarrays {
    public static void main(String[] args) {
        var app = new Count_Number_of_Nice_Subarrays();
        int[] arr = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;

        int result = app.numberOfSubarrays(arr, k);
        System.out.println(result);
    }

    public int numberOfSubarrays(int[] nums, int k) {
        // Map nums to bitArray according the following rules:
        // if nums[i] isOdd => 1
        // if nums[i] isEven => 0
        // as the result get the array like this [1, 0, 1, 1, 0, 1, 0, 0, 1];
        // Next task is the same as finding number of subarrays with sum K

         boolean[] bitArray = new boolean[nums.length];
         // map: prefixSum -> count
         var map = new HashMap<Integer, Integer>();
         map.put(0, 1);

         int result = 0;
         int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (isOdd(nums[i]))
                bitArray[i] = true;

            currentSum = currentSum + (bitArray[i] ? 1 : 0);

            if (map.containsKey(currentSum - k))
                result += map.get(currentSum - k);

            // contains
            map.merge(currentSum, 1, Integer::sum);
        }

        return result;
    }

    public int numberOfSubarraysOptimized(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        int result = 0;
        int currentSum = 0;

        for (int num : nums) {
            if (num % 2 != 0)
                currentSum++;

            if (map.containsKey(currentSum - k))
                result += map.get(currentSum - k);

            Integer value = map.get(currentSum);

            // contains
            if (value != null)
                map.put(currentSum, value + 1);
            else
                map.put(currentSum, 1);
        }

        return result;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
