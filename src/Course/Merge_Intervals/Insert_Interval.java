package Course.Merge_Intervals;

import java.util.LinkedList;
import java.util.List;

public class Insert_Interval {
    public static List<Interval> insertInterval(List<Interval> existingIntervals, Interval newInterval) {
        var result = new LinkedList<Interval>();
        for (var interval : existingIntervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (newInterval.end < interval.start) {
                result.add(newInterval);
                newInterval = interval;
            } else {
                // merge
                newInterval.setStart(Math.min(interval.start, newInterval.start));
                newInterval.setEnd(Math.max(interval.end, newInterval.end));
            }
        }
        result.add(newInterval);
        return result;
    }
}
