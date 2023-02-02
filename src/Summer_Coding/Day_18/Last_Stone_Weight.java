package Summer_Coding.Day_18;

import java.util.PriorityQueue;

public class Last_Stone_Weight {
    public int lastStoneWeight(int[] stones) {
        var pq = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        for (int a : stones)
            pq.add(a);
        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (x != y) {
                pq.add(y - x);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
