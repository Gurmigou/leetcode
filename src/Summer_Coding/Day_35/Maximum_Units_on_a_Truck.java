package Summer_Coding.Day_35;

public class Maximum_Units_on_a_Truck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] buckets = new int[1001];
        for (int[] boxType : boxTypes) {
            buckets[boxType[1]] += boxType[0];
        }
        int result = 0;
        for (int i = 1000; truckSize > 0 && i >= 0; i--) {
            if (buckets[i] == 0)
                continue;
            result += Math.min(buckets[i], truckSize) * i;
            truckSize -= buckets[i];
        }
        return result;
    }
}
