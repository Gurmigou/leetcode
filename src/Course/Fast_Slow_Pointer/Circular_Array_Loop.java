package Course.Fast_Slow_Pointer;

public class Circular_Array_Loop {
    public static void main(String[] args) {
        boolean result = circularArrayLoop(new int[]{-1, -1, -1, -1, -1, -1});
        System.out.println(result);
    }

    public static boolean circularArrayLoop(int[] nums) {
        int slow;
        int fast;
        boolean direction;

        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) == nums.length)
                continue;

            slow = i;
            fast = i;

            direction = nums[slow] >= 0;

            while (true) {
                slow = nextStep(nums, slow, direction);
                if (slow == -1)
                    break;

                fast = nextStep(nums, fast, direction);
                if (fast == -1)
                    break;
                fast = nextStep(nums, fast, direction);

                if (fast == slow || fast == -1)
                    break;
            }

            if (fast == slow)
                return true;
        }
        return false;
    }

    private static int nextStep(int[] nums, int index, boolean direction) {
        int next = nums[index];
        if (next < 0 && direction || next > 0 && !direction)
            return -1;
        return format(index + next, nums.length);
    }

    private static int format(int index, int n) {
        if (index >= 0 && index < n)
            return index;
        return index >= n ? formatUpperBound(index, n) : formatLowerBound(index, n);
    }

    private static int formatUpperBound(int index, int n) {
        return index % n;
    }

    private static int formatLowerBound(int index, int n) {
        return n + (index % n);
    }
}
