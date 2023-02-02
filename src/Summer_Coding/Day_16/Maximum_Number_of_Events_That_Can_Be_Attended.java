package Summer_Coding.Day_16;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Maximum_Number_of_Events_That_Can_Be_Attended {
    public static void main(String[] args) {
        var app = new Maximum_Number_of_Events_That_Can_Be_Attended();

        int[][] events = {new int[] {1, 4}, new int[] {4, 4}, new int[] {2, 2}, new int[] {3, 4}, new int[] {1, 1}};
        int result = app.maxEvents(events);
        System.out.println(result);
    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // heap of events' end days
        var pq = new PriorityQueue<Integer>();

        int i = 0;
        int day = 1;
        int result = 0;
        while (i != events.length || !pq.isEmpty()) {
            while (i < events.length && events[i][0] == day) { // add to the pq all events that start on that day
                pq.add(events[i][1]);
                i++;
            }
            // remove all events that have already passed
            while (!pq.isEmpty() && pq.peek() < day)
                pq.poll();
            // if pq is not empty go to the current event
            if (!pq.isEmpty()) {
                result++;
                pq.poll();
            }
            day++;
        }

        return result;
    }
}
