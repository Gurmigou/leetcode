package Course.Merge_Intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee_Free_Time {
    public static List<Interval> employeeFreeTime(ArrayList<ArrayList<Interval>> schedule) {
        var allIntervals = schedule
                .stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Interval::getStart))
                .toList();

        if (allIntervals.size() < 2)
            return Collections.emptyList();

        var result = new ArrayList<Interval>();

        int maxEnd = allIntervals.get(0).getEnd();
        for (int i = 1; i < allIntervals.size(); i++) {
            var cur = allIntervals.get(i);
            if (maxEnd < cur.start) {
                result.add(new Interval(maxEnd, cur.start));
            }
            maxEnd = Math.max(maxEnd, cur.end);
        }
        return result;
    }
}
