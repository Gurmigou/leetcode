package Course.Two_Pointers;

public class Two_Sum_II_Input_Array_Is_Sorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (true) {
            int sum = numbers[l] + numbers[r];

            if (sum == target)
                return new int[]{l + 1, r + 1};

            if (sum > target)
                r--;
            else
                l++;
        }
    }
}
