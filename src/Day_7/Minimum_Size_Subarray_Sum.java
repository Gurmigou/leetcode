package Day_7;

public class Minimum_Size_Subarray_Sum {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        int target = 15;

        var app = new Minimum_Size_Subarray_Sum();
        int result = app.minSubArrayLen(target, arr);
        System.out.println(result);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;

        int minLengthResult = Integer.MAX_VALUE;
        int sum = 0;

        do {
            if (sum >= target) {
                minLengthResult = Math.min(minLengthResult, (r - l));
                sum -= nums[l];
                l++;
            } else {
                sum += nums[r];
                r++;
            }
        } while (l < r && r != nums.length);

        if (r == nums.length) {
            for (int i = l; i < r; i++) {
                if (sum >= target) {
                    minLengthResult = Math.min(minLengthResult, (r - l));
                    sum -= nums[l];
                    l++;
                } else
                    break;
            }
        }

        return (minLengthResult == Integer.MAX_VALUE) ? 0 : minLengthResult;
    }
}
