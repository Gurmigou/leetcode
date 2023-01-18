package Google_OA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task_2 {
    public static int solution(int[] A) {
        if (A.length < 4)
            return -1;

        int atLeastTwoCount = 0;

        // side -> count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int side : A) {
            if (map.containsKey(side)) {
                int count = map.get(side);
                if (count + 1 >= 4)
                    return 0;
                if (count + 1 == 2) {
                    atLeastTwoCount += 1;
                }
                map.put(side, count + 1);
            } else {
                map.put(side, 1);
            }
        }

        if (atLeastTwoCount < 2)
            return -1;

        int[] properSides = new int[atLeastTwoCount];
        int index = 0;
        for (Map.Entry<Integer, Integer> keyValue : map.entrySet()) {
            if (keyValue.getValue() >= 2) {
                properSides[index] = keyValue.getKey();
                index++;
            }
        }


        Arrays.sort(properSides);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < properSides.length - 1; i++) {
            result = Math.min(result, Math.abs(properSides[i] - properSides[i + 1]));
        }
        return result;
    }
}
