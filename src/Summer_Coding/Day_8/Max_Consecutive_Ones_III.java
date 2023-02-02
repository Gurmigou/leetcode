package Summer_Coding.Day_8;

public class Max_Consecutive_Ones_III {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0};
        int k = 0;

        var app = new Max_Consecutive_Ones_III();
        int result = app.longestOnes(arr, k);
        System.out.println(result);
    }

    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int result = 0;

        while (r < nums.length) {
            sum += nums[r];

            while (l != r && r - l + 1 > sum + k) {
                sum -= nums[l];
                l++;
            }

            // if case for nums = [0, 0, 0, ..., 0];
            if (sum != 0 || k != 0)
                result = Math.max(result, r - l + 1);

            r++;
        }

        return result;
    }
}
