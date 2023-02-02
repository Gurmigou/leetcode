package Summer_Coding.Day_5;

import java.util.Arrays;

public class Frequency_of_the_Most_Frequent_Element {
    public static void main(String[] args) {
        var app = new Frequency_of_the_Most_Frequent_Element();

        int[] arr = {1, 2, 4};
        int k = 5;
        int result = app.maxFrequency(arr, k);
        System.out.println(result);
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = 0;
        int maxWindowLength = 0;
        long totalSum = 0;

        // nums[right] is pointing to the main element of the group.
        // This means that all elements in the group have value of nums[right]
        // (right - left + 1) == windowLength - the length of the group
        // nums[right] * windowLength - value of the group
        // totalSum - sum of real values of array elements in the interval [left, right]
        // totalSum + k - maximum possible value of the window to satisfy k parameter
        while (right < nums.length) {
            totalSum += nums[right];

            while ((long) nums[right] * (right - left + 1) > totalSum + k) {
                totalSum -= nums[left];
                left++;
            }

            maxWindowLength = Math.max(maxWindowLength, (right - left + 1));
            right++;
        }

        return maxWindowLength;
    }
}
