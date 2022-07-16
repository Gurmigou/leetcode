package Day_2;

public class Find_the_Smallest_Divisor_Given_a_Threshold {
    public static void main(String[] args) {
        var app = new Find_the_Smallest_Divisor_Given_a_Threshold();

        int[] arr = {1,2,5,9};
        int threshold = 6;

        System.out.println(app.smallestDivisor(arr, threshold));
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int smallestDivisor = Integer.MAX_VALUE;

        int low = 0;
        int high = nums[0];
        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low <= high) {
            int middle = (low + high) / 2;

            // try to find minimum divisor that satisfies: divisor <= threshold
            if (roundedSum(nums, middle) <= threshold) {
                smallestDivisor = middle;
                high = middle - 1;
            } else
                low = middle + 1;
        }

        return smallestDivisor;
    }

    private static int roundedSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + round(num, divisor);
        }
        return sum;
    }
    private static int round(int value, int divisor) {
        if (value % divisor == 0)
            return value / divisor;
        else
            return (value / divisor) + 1;
    }
}
