package Course.Merge_Intervals;

import java.util.LinkedList;
import java.util.List;

public class Merge_Intervals {
    public static List<Interval> mergeIntervals(List<Interval> l) {
        LinkedList<Interval> result = new LinkedList<>();

        for (var interval : l) {
            if (result.isEmpty()) {
                result.addLast(interval);
                continue;
            }

            Interval prev = result.getLast();

            if (overlaps(prev, interval)) {
                merge(prev, interval, prev);
            } else {
                result.addLast(interval);
            }
        }
        return result;
    }

    private static void merge(Interval i1, Interval i2, Interval result) {
        result.start = Math.min(i1.start, i2.start);
        result.end = Math.max(i1.end, i2.end);
    }

    private static boolean overlaps(Interval i1, Interval i2) {
        return !(i1.end < i2.start || i1.start > i2.end);
    }


}
