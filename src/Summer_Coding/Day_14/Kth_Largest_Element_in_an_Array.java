package Summer_Coding.Day_14;

public class Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(0, nums.length - 1, nums, k);
    }

    public void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    public int quickSelect(int l, int r, int[] nums, int k) {
        int pivot = nums[r];
        int p = l;

        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, p);
                p++;
            }
        }

        swap(nums, p, r);

        if (p > k)
            return quickSelect(l, p - 1, nums, k);
        else if (p < k)
            return quickSelect(p + 1, r, nums, k);
        else
            return nums[p];
    }
}
