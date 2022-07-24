package Day_13;

public class Subarray_Product_Less_Than_K {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1;
        int result = 0;

        int l = 0;
        int r = 0;

        while (r < nums.length) {
            prod *= nums[r];

            while (prod >= k) {
                prod /= nums[l];
                l++;
            }

            result += r - l + 1;
            r++;
        }

        return result;
    }
}
