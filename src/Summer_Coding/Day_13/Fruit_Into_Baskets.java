package Summer_Coding.Day_13;

import java.util.HashMap;

public class Fruit_Into_Baskets {
    public static void main(String[] args) {
        var app = new Fruit_Into_Baskets();

        int[] fruits = {1, 2, 1, 3, 2, 2};
        int result = app.totalFruit(fruits);

        System.out.println(result);
    }

    public static void removeMap(HashMap<Integer, Integer> map, Integer key) {
        Integer value = map.get(key);
        if (value != null) {
            if (value > 1)
                map.put(key, value - 1);
            else
                map.remove(key);
        }
    }

    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int result = 0;

        int l = 0;
        int r = 0;

        while (r < fruits.length) {
            map.merge(fruits[r], 1, Integer::sum);

            while (map.size() > 2) {
                removeMap(map, fruits[l]);
                count--;
                l++;
            }

            count++;
            r++;
            result = Math.max(result, count);
        }

        return result;
    }
}
