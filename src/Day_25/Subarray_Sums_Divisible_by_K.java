package Day_25;

public class Subarray_Sums_Divisible_by_K {
    public static void main(String[] args) {
        var app = new Subarray_Sums_Divisible_by_K();
        int[] arr = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int result = app.subarraysDivByK(arr, k);
        System.out.println(result);
    }

    public int subarraysDivByK(int[] nums, int k) {
        int result = 0;
        int[] storage = new int[k];
        storage[0] = 1;

        int currentSum = 0;
        for (int num : nums) {
            currentSum = (currentSum + num) % k;
            if (currentSum < 0)
                currentSum += k;

            result += storage[currentSum];
            storage[currentSum]++;
        }

        return result;
    }
}
