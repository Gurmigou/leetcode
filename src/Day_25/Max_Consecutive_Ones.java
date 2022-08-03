package Day_25;

public class Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int index = 0;
        int count = 0;
        while (index < nums.length) {
            if (nums[index] != 1) {
                result = Math.max(result, count);
                count = 0;
            }
            else
                count++;
            index++;
        }
        result = Math.max(result, count);
        return result;
    }
}
