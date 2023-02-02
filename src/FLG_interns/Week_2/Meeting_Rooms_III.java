package FLG_interns.Week_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Meeting_Rooms_III {
    public static void main(String[] args) {
        int[][] meetings = new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}};
        int n = 3;
        var app = new Meeting_Rooms_III();
        int mostBooked = app.mostBooked(n, meetings);
        System.out.println(mostBooked);
    }

    public int mostBooked(int n, int[][] meetings) {
        // int[] = [end, room_index]
        var busyEnd = new PriorityQueue<long[]>((a, b) -> (a[0] == b[0]) ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        var available = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++)
            available.add(i);

        int[] rooms = new int[n];

        Arrays.sort(meetings, Comparator.comparing(arr -> arr[0]));

        for (var meeting : meetings) {
            while (!busyEnd.isEmpty() && busyEnd.peek()[0] <= meeting[0]) {
                var removed = busyEnd.poll();
                available.add((int) removed[1]);
            }

            if (!available.isEmpty()) {
                int availableRoom = available.poll();
                rooms[availableRoom] += 1;
                busyEnd.add(new long[]{meeting[1], availableRoom});
            } else {
                var closest = busyEnd.poll();
                rooms[(int) closest[1]] += 1;

                long endShifted = meeting[1] + Math.max(closest[0] - meeting[0], 0);
                busyEnd.add(new long[]{endShifted, closest[1]});
            }
        }

        int max = rooms[0];
        int maxIndex = 0;
        for (int i = 1; i < rooms.length; i++) {
            if (rooms[i] > max) {
                max = rooms[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
