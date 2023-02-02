package Summer_Coding.Day_3;

public class Capacity_To_Ship_Packages_Within_D_Days {
    public static void main(String[] args) {
        int[] weight = {3, 2, 2, 4, 1, 4};
        int targetDays = 3;

        var app = new Capacity_To_Ship_Packages_Within_D_Days();
        int minWeight = app.shipWithinDays(weight, targetDays);
        System.out.println(minWeight);
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int a : weights)
            high += a;

        int minShipWeight = 0;
        while (low <= high) {
            int supposeWeight = (low + high) / 2;

            if (isEnoughCapacityToShipInDday(supposeWeight, days, weights)) {
                minShipWeight = supposeWeight;
                high = supposeWeight - 1;
            } else
                low = supposeWeight + 1;
        }

        return minShipWeight;
    }

    private boolean isEnoughCapacityToShipInDday(int supposeMinWeight, int days, int[] weights) {
        int i = 0;
        int daysCount = 0;
        while (i < weights.length && daysCount <= days) {

            int weightCount = 0;
            while (i < weights.length && weightCount + weights[i] <= supposeMinWeight) {
                weightCount += weights[i];
                i++;
            }

            daysCount++;
        }
        return daysCount <= days;
    }
}
