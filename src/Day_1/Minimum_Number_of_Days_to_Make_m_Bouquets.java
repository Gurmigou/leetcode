package Day_1;

public class Minimum_Number_of_Days_to_Make_m_Bouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length)
            return - 1;

        // min and max bloom days
        int low = 1;
        int high = bloomDay[0];
        for (int i = 1; i < bloomDay.length; i++) {
            high = Math.max(high, bloomDay[i]);
        }

        // min number of days
        int answer = -1;

        // using binary search find min num of days;
        while (low <= high) {
            // middle is possible min bloom day (answer)
            int middle = (low + high) / 2;

            if (isPossibleToMake(bloomDay, middle, m, k)) {
                answer = middle;
                // try to find less
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return answer;
    }

    private boolean isPossibleToMake(int[] bloomDay, int day, int m, int k) {
        int n = bloomDay.length;
        int i = 0;

        int canMakeBouquets = 0;

        while (i < n) {
            if (bloomDay[i] > day) {
                i++;
                continue;
            }

            int j = i + 1;
            int flowersCounter = 1;

            while (j < n && bloomDay[j] <= day && flowersCounter < k) {
                flowersCounter++;
                j++;
            }

            if (flowersCounter == k)
                canMakeBouquets++;

            // next iteration start from j index (end in the current iteration)
            i = j;
         }

        return canMakeBouquets >= m;
    }
}
