package Other_Topics.Monotonic_Stack;

import java.util.Stack;

public class Daily_Temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        // [value, index]
        var monotonicStack = new Stack<int[]>();

        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!monotonicStack.isEmpty() && monotonicStack.peek()[0] < temperatures[i]) {
                var popped = monotonicStack.pop();
                result[popped[1]] = i - popped[1];
            }
            monotonicStack.push(new int[] {temperatures[i], i});
        }

        while (!monotonicStack.isEmpty()) {
            result[monotonicStack.pop()[1]] = 0;
        }

        return result;
    }
}
