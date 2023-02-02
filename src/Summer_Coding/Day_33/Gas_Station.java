package Summer_Coding.Day_33;

import java.text.ParseException;

public class Gas_Station {
    public static void main(String[] args) throws ParseException {
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int sum = gas[start] - cost[start];
        while (start > end) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                end++;
            } else {
                sum += gas[start] - cost[start];
                start--;
            }
        }

        return sum >= 0 ? start : -1;
    }
}
