package Summer_Coding.Day_34;

public class Jump_Game_II {
    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(jump(nums));
        System.out.println(jumpIterative(nums));
    }

    static final int INF__ = 100001;

    public static int jump(int[] nums) {
        int[] shortestMemo = new int[nums.length];
        return jumpDfs(nums, shortestMemo, 0);
    }

    public static int jumpDfs(int[] nums, int[] shortestMemo, int index) {
        if (index >= nums.length - 1)
            return 0;

        if (shortestMemo[index] != 0 && shortestMemo[index] != INF__)
            return shortestMemo[index];

        int maxSteps = nums[index];
        int min = INF__;
        for (int i = maxSteps; i >= 1; i--) {
            min = Math.min(min, jumpDfs(nums, shortestMemo, index + i) + 1);
            if (min == 0)
                break;
        }

        shortestMemo[index] = min;
        return min;
    }

    public static int jumpIterative(int[] nums) {
        int l = 0;
        int r = 0;
        int result = 0;
        while (r < nums.length - 1) {
            int fastest = 0;
            for (int i = l; i <= r; i++) {
                fastest = Math.max(fastest, i + nums[i]);
            }
            l = r + 1;
            r = fastest;
            result += 1;
        }
        return result;
    }
}
