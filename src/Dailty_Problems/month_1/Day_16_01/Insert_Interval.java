package Dailty_Problems.month_1.Day_16_01;

import java.util.LinkedList;

public class Insert_Interval {
    public static void main(String[] args) {
        // [[0,4],[7,12]]
        // [0,5]
        int[][] input = {{0, 4}, {7, 12}};
        int[] newInterval = {0, 5};
        var app = new Insert_Interval();
        int[][] result = app.insert(input, newInterval);
        for (int[] pair : result) {
            System.out.println(pair[0] + ", " + pair[1]);
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][]{newInterval};

        int insertPosition = -1;

        if (newInterval[0] <= intervals[0][0]) {
            insertPosition = 0;
        } else {
            for (int i = 0; i < intervals.length - 1; i++) {
                var interval = intervals[i];
                var nextInterval = intervals[i + 1];
                if (newInterval[0] >= interval[0] && newInterval[0] < nextInterval[0]) {
                    insertPosition = i + 1;
                }
            }
        }
        if (insertPosition == -1) {
            insertPosition = intervals.length;
        }

        LinkedList<int[]> result = new LinkedList<>();

        int length = intervals.length + 1;
        for (int i = 0; i < length; i++) {
            int[] curInterval;
            if (i == insertPosition) {
                curInterval = newInterval;
            } else {
                curInterval = intervals[i];
            }

            if (result.isEmpty()) {
                result.addLast(curInterval);

                if (i == insertPosition) {
                    length -= 1;
                    i--;
                    insertPosition = -1;
                }
                continue;
            }

            int[] prev = result.getLast();

            if (overlaps(curInterval, prev)) {
                merge(curInterval, prev, prev);
            } else {
                result.addLast(curInterval);
            }

            if (i == insertPosition) {
                length -= 1;
                i--;
                insertPosition = -1;
            }
        }

        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    private boolean overlaps(int[] i1, int[] i2) {
        return !(i1[1] < i2[0] || i1[0] > i2[1]);
    }

    private void merge(int[] i1, int[] i2, int[] result) {
        result[0] = Math.min(i1[0], i2[0]);
        result[1] = Math.max(i1[1], i2[1]);
    }
}
