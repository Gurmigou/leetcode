package Course.Two_Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Find_Right_Interval {
    public static void main(String[] args) {
        var app = new Find_Right_Interval();
        int[] rightInterval = app.findRightInterval(new int[][]{{1, 2}});
        System.out.println(Arrays.toString(rightInterval));
    }

    public int[] findRightInterval(int[][] intervals) {
        var maxHeapStart = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[0], a[0]));
        var maxHeapEnd = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[0], a[0]));
        int index = 0;
        for (var interval : intervals) {
            maxHeapStart.add(new int[] {interval[0], index});
            maxHeapEnd.add(new int[] {interval[1], index});
            index++;
        }

        int[] result = new int[intervals.length];

        while (!maxHeapEnd.isEmpty()) {
            var endTop = maxHeapEnd.poll();

            int[] minGreaterStart = null;
            while (!maxHeapStart.isEmpty() && maxHeapStart.peek()[0] >= endTop[0]) {
                minGreaterStart = maxHeapStart.poll();
            }

            if (minGreaterStart == null) {
                result[endTop[1]] = -1;
            } else {
                result[endTop[1]] = minGreaterStart[0];
                maxHeapStart.add(minGreaterStart);
            }
        }

        return result;
    }
}
