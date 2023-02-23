package FLG_interns.Week_5;

public class Count_Array_Pairs_Divisible_by_K {
    public static void main(String[] args) {
        var app = new Count_Array_Pairs_Divisible_by_K();
        app.countPairs(new int[]{1, 2, 3, 4, 5}, 2);
    }

    public long countPairs(int[] nums, int k) {
        int[] store = new int[k];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int rem1 = nums[i] % k;
            if (rem1 == 0) {
                result += store[0];
            } else {
                result += store[k - rem1];
            }
            store[rem1]++;
        }
        return result;
    }
}
