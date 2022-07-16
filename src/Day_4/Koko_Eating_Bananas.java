package Day_4;

public class Koko_Eating_Bananas {
    public int minEatingSpeed(int[] piles, int h) {
        long low = 1;
        long high = 0;
        for (int bananas : piles)
            high += bananas;

        // K - minimum number of bananas that a koko can eat in 1 hour to finish on time
        int minimumK = Integer.MAX_VALUE;
        while (low <= high) {
            long supposeMinK = (low + high) / 2;

            if (canEatAllBananasInHhours(piles, supposeMinK, h)) {
                minimumK = (int)supposeMinK;
                high = supposeMinK - 1;
            } else {
                low = supposeMinK + 1;
            }
        }

        return minimumK;
    }

    private boolean canEatAllBananasInHhours(int[] piles, long supposeMinK, int h) {
        int hoursRequired = 0;
        int i = 0;

        while (i < piles.length) {
            if (hoursRequired > h)
                break;

            long requiredHoursToBananasInPile_i;
            if (piles[i] % supposeMinK == 0)
                requiredHoursToBananasInPile_i = piles[i] / supposeMinK;
            else
                requiredHoursToBananasInPile_i = piles[i] / supposeMinK + 1;

            hoursRequired += requiredHoursToBananasInPile_i;
            i++;
        }

        return hoursRequired <= h;
    }
}
