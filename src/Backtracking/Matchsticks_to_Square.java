package Backtracking;

import java.util.Arrays;
import java.util.Collections;

public class Matchsticks_to_Square {
    private void reverseSort(int[] arr) {
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0)
            return false;

        int side = sum / 4;
        int[] sides = new int[4];
        reverseSort(matchsticks);

        return backtracking(sides, 0, matchsticks, side);
    }

    private boolean backtracking(int[] sides, int stickIndex, int[] matchsticks, int sideLength) {
        if (stickIndex == matchsticks.length)
            return true;

        for (int direction = 0; direction < 4; direction++) {
            if (sides[direction] + matchsticks[stickIndex] <= sideLength) {
                sides[direction] += matchsticks[stickIndex];
                if (backtracking(sides, stickIndex + 1, matchsticks, sideLength))
                    return true;
                sides[direction] -= matchsticks[stickIndex];
            }
        }
        return false;
    }
}
