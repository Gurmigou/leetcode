package Day_24;

import java.util.Arrays;

public class Product_of_Array_Except_Self {
    public static void main(String[] args) {
        var app = new Product_of_Array_Except_Self();

        int[] arr = {1, 2, 3, 4};

        int[] ints = app.productExceptSelf(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }
}
