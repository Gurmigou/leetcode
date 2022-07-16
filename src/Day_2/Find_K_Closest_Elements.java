package Day_2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Math.abs;

public class Find_K_Closest_Elements {
    public static void main(String[] args) {
        var app = new Find_K_Closest_Elements();
        int[] arr = {-1, 4, 6, 10, 11, 12, 15, 16};
        int x = 8;
        int k = 3;

        List<Integer> closestElements1 = app.findClosestElements1(arr, x, k);
        List<Integer> closestElements2 = app.findClosestElements2(arr, x, k);

        List<Integer> closestElements3 = app.findClosestElements3(arr, x, k);

        System.out.println(closestElements1);
        System.out.println(closestElements2);
    }

    // Approach #1 using two pointers (easiest to understand)
    public List<Integer> findClosestElements1(int[] arr, int x, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right && (right - left) + 1 != k) {
            if (abs(x - arr[left]) < abs(x - arr[right])) {
                right--;
            } else {
                left++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    // Approach #2 using binary search (the best in time complexity, but difficult to understand)
    public List<Integer> findClosestElements2(int[] arr, int x, int k) {
        int low = 0;
        int high = arr.length - k;

        while (low < high) {
            //  L      M          R
            //  |      |________  |
            // [-1, 4, 6, 10, 11, 12, 15, 16]
            int middle = (low + high) / 2;

            if (x - arr[middle] <= arr[middle + k] - x)
                high = middle;
            else
                low = middle + 1;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    // Approach #3 using min-heap the least efficient but easy to implement
    public List<Integer> findClosestElements3(int[] arr, int k, int x) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((i1, i2) ->
                (abs(i1 - x) < abs(i2 - x)) ? -1 : (abs(i1 - x) > abs(i2 - x)) ? 1 : (i1 < i2) ? -1 : 1);

        // -1 - 3 = 4
        // 4 - 3 = 1

        for (int a : arr)
            heap.add(a);

        System.out.println(heap);
        return null;
    }
}
