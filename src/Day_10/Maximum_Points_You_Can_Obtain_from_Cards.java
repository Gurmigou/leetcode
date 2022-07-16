package Day_10;

import java.util.HashMap;

public class Maximum_Points_You_Can_Obtain_from_Cards {
    public static void main(String[] args) {
        var app = new Maximum_Points_You_Can_Obtain_from_Cards();

        int[] arr = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;

        int result = app.maxScoreBetterSolution(arr, k);
        System.out.println(result);
    }

    public static HashMap<Integer, Integer> createPrefixSumMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            map.put(i, prefixSum);
        }
        map.put(-1, 0);
        return map;
    }

    public int maxScore(int[] cardPoints, int k) {
        HashMap<Integer, Integer> prefixMap = createPrefixSumMap(cardPoints);

        int l = 0;
        int r = cardPoints.length - 1;
        int index = 0;
        int result = 0;

        while (index < k) {
            int leftPrefix = prefixMap.get(l + k - 1 - index) - prefixMap.get(l - 1);
            int rightPrefix = prefixMap.get(r) - prefixMap.get(r - k + index);

            if (leftPrefix > rightPrefix) {
                result += cardPoints[l];
                l++;
            } else {
                result += cardPoints[r];
                r--;
            }

            index++;
        }

        return result;
    }

    public int maxScoreBetterSolution(int[] cardPoints, int k) {
        if (cardPoints.length == k) {
            int sum = 0;
            for (int a : cardPoints)
                sum += a;
            return sum;
        }

        int l = 0;
        int r = cardPoints.length - k;

        int maxSum = 0;
        for (int i = r; i < cardPoints.length; i++)
            maxSum += cardPoints[i];

        int currentSum = maxSum;

        while (r < cardPoints.length) {
            currentSum = currentSum - cardPoints[r] + cardPoints[l];
            if (currentSum > maxSum)
                maxSum = currentSum;
            l++;
            r++;
        }

        return maxSum;
    }
}
