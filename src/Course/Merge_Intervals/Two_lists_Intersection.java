package Course.Merge_Intervals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Two_lists_Intersection {
    public static void main(String[] args) {
//        [[2, 6], [7, 9], [10, 13], [14, 19], [20, 24]]
        List<Interval> a = List.of(new Interval(1, 4), new Interval(5, 6), new Interval(7, 9));
//        [[1, 4], [6, 8], [15, 18]]
        List<Interval> b = List.of(new Interval(3, 5), new Interval(6, 7), new Interval(8, 9));
        System.out.println(intervalsIntersection(a, b));

    }

    public int[] foo() {
        return new int[] {1, 2};

    }

    public static List<Interval> intervalsIntersection(List<Interval> intervalListA, List<Interval> intervalListB) {
        if (intervalListA.isEmpty() && intervalListB.isEmpty())
            return Collections.emptyList();
        if (intervalListA.isEmpty())
            return intervalListB;
        if (intervalListB.isEmpty())
            return intervalListA;

        var result = new LinkedList<Interval>();
        int first = 0;
        int second = 0;

        Interval a = intervalListA.get(0);
        Interval b = intervalListB.get(0);

        while (true) {
            var merged = merge(a, b);
            if (merged != null)
                result.add(merged);
            var next = getWithGreaterEnd(a, b);
            if (next == a) {
                second++;
                if (second >= intervalListB.size())
                    break;
                b = intervalListB.get(second);
            } else {
                first++;
                if (first >= intervalListA.size())
                    break;
                a = intervalListA.get(first);
            }
        }
        return result;
    }

    private static Interval getWithGreaterEnd(Interval i1, Interval i2) {
        return i1.end > i2.end ? i1 : i2;
    }

    private static Interval merge(Interval i1, Interval i2) {
        if (i1.end < i2.start || i2.end < i1.start)
            return null;
        return new Interval(Math.max(i1.start, i2.start), Math.min(i1.end, i2.end));
    }
}
