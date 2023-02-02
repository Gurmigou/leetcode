package Summer_Coding.Day_16;

import Util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Task_Scheduler {
    public static void main(String[] args) {
        var app = new Task_Scheduler();

        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2;

        int result = app.leastInterval(tasks, n);
        int analyticResult = app.leastIntervalAnalytic(tasks, n);

        System.out.println(result);
        System.out.println(analyticResult);
    }

    // O(n) * O(uniqueN)
    public int leastInterval(char[] tasks, int n) {
        // O(n)
        var map = new HashMap<Character, Integer>();
        for (char c : tasks)
            map.merge(c, 1, Integer::sum);

        // O(n)
        var pq = new PriorityQueue<Pair<Character, Integer>>((p1, p2) -> Integer.compare(p2.second, p1.second));
        for (var entry : map.entrySet())
            pq.add(Pair.of(entry.getKey(), entry.getValue()));

        int operationIndex = 0;
        var operations = new HashMap<Character, Integer>();

        // O(n)
        while (!pq.isEmpty()) {
            Pair<Character, Integer> nextOperation = null;

            // O(uniqueN)
            for (var pair : pq) {
                if (operations.get(pair.first) == null || operationIndex - operations.get(pair.first) > n) {
                    nextOperation = pair;
                    break;
                }
            }

            // O(log(uniqueN))
            if (nextOperation != null) {
                pq.remove(nextOperation);
                operations.put(nextOperation.first, operationIndex);

                nextOperation.second--;
                if (nextOperation.second != 0)
                    pq.add(nextOperation);
            }

            operationIndex++;
        }

        return operationIndex;
    }


    public int leastIntervalAnalytic(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int m = tasks.length;
        int[] cnt = new int[26];
        /* Build the count array with frequency of each task */
        for (char c: tasks) {
            cnt[c - 'A']++;
        }
        Arrays.sort(cnt);
        /* Get maximum frequency task  and calculate max idle spaces*/
        int max = cnt[25]-1;
        int spaces = max * n;

        /* Iterate over rest of the array and reduce the idle space count */
        for (int i = 24; i >= 0; i--) {
            spaces -= Math.min(max, cnt[i]);
        }
        /* Handle cases when spaces become negative */
        spaces = Math.max(0, spaces);
        return tasks.length + spaces;
    }
}

