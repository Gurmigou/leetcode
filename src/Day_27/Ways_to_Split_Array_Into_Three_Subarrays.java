package Day_27;

public class Ways_to_Split_Array_Into_Three_Subarrays {
    public static void main(String[] args) {
        var app = new Ways_to_Split_Array_Into_Three_Subarrays();
        int[] nums = {7, 2, 5, 5, 6, 2, 10, 9};
        int i = app.waysToSplit(nums);
        System.out.println(i);
    }

    public int waysToSplit(int[] nums) {
        final int MOD = (int) (1e9 + 7);
        int n = nums.length;

        int[] presum = new int[n];
        presum[0] = nums[0];
        for (int i = 1; i < n; i++)
            presum[i] = presum[i - 1] + nums[i];

        int result = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = presum[i];
            int remain = presum[n - 1] - left;

            if (presum[n - 1] < left * 3)
                break;

            int l = findLeft(i + 1, left, n, presum);
            int r = findRight(i + 1, remain / 2, n, presum);

            result = (result + ((r - l) + 1) % MOD) % MOD;
        }

        return result;
    }

    private int findLeft(int i, int target, int n, int[] presum) {
        // find minimum left such that it is >= target
        int l = i;
        int r = n - 2;
        int result = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (presum[m] - presum[i - 1] >= target) {
                result = m;
                r = m - 1;
            }
            else
                l = m + 1;
        }

        return result;
    }

    private int findRight(int i, int target, int n, int[] presum) {
        // find maximum right such that it is <= target
        int l = i;
        int r = n - 2;
        int result = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (presum[m] - presum[i - 1] <= target) {
                result = m;
                l = m + 1;
            }
            else
                r = m - 1;
        }

        return result;
    }
}
