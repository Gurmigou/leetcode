package Day_3;

public class Find_the_Duplicate_Number {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        var app = new Find_the_Duplicate_Number();

        app.findDuplicate(arr);
    }

    // Using Floyd's cycle detection algorithm
    public int findDuplicate(int[] nums) {
        // 0 will never be in cycle because all nums are in range [1, n]
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int slow2 = 0;

        // Iterate until slow != slow2
        do {
            slow = nums[slow];
            slow2 = nums[slow2];
        } while (slow != slow2);

        // Slow will point to the start of the cycle
        return slow;
    }
}
