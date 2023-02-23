package FLG_interns.Week_4;

import java.util.ArrayDeque;

public class Maximum_Number_of_Robots_Within_Budget {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int l = 0;
        // [element, index]
        var monoQueue = new ArrayDeque<long[]>();
        long sum = 0;
        long result = 0;
        for (int r = 0; r < chargeTimes.length; r++) {
            sum += runningCosts[r];

            // monotonic queue conditions
            while (!monoQueue.isEmpty() && monoQueue.getLast()[0] < chargeTimes[r]) {
                monoQueue.pollLast();
            }
            monoQueue.addLast(new long[]{chargeTimes[r], r});

            // moving window to the left
            while (!monoQueue.isEmpty() && monoQueue.getFirst()[0] + (long) (r - l + 1) * sum > budget) {
                if (monoQueue.getFirst()[1] <= l)
                    monoQueue.pollFirst();
                sum -= runningCosts[l];
                l += 1;
            }

            // the condition is now met
            result = Math.max(result, (r - l + 1));
        }
        return (int) result;
    }
}
