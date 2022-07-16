package Day_6;

import java.util.Arrays;

public class Valid_Triangle_Number {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4};

        var app = new Valid_Triangle_Number();
        int result = app.triangleNumber(arr);
        System.out.println(result);
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for (int i = nums.length - 1; i >= 2; i--) {
            int j = 0;
            int k = i - 1;

            while (j < k) {
                if (nums[j] + nums[k] > nums[i]) {
                    count += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }

        return count;
    }
}
