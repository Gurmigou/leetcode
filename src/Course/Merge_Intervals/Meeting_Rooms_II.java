package Course.Merge_Intervals;

import java.util.*;

public class Meeting_Rooms_II {
    public static int minMeetingRooms(List<Interval> meetingTimes) {
        Queue<Integer> heap = new PriorityQueue<>();
        meetingTimes.sort(Comparator.comparing(Interval::getStart));

        int count = 0;
        int maxCount = 0;

        for (var interval : meetingTimes) {
            if (heap.isEmpty() || interval.start < heap.peek()) {
                count += 1;
                heap.add(interval.end);
            } else {
                count -= 1;
                heap.poll();
            }
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }

    public static int minMeetingRooms2(List<Interval> meetingTimes) {
        int[] start = new int[meetingTimes.size()];
        int[] end = new int[meetingTimes.size()];
        for (int i = 0; i < meetingTimes.size(); i++) {
            start[i] = meetingTimes.get(i).start;
            end[i] = meetingTimes.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0;
        int maxCount = 0;

        int s = 0, e = 0;
        while (s < start.length) {
            if (start[s] < end[e]) {
                count += 1;
                s += 1;
            } else {
                count -= 1;
                e += 1;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
























