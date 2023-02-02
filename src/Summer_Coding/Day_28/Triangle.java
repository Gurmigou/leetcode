package Summer_Coding.Day_28;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] memory = new int[triangle.get(triangle.size() - 1).size()];
        int index = 0;
        for (int i : triangle.get(triangle.size() - 1))
            memory[index++] = i;

        for (int level = triangle.size() - 2; level > 0; level--) {
            index = 0;
            for (int i = 0; i < triangle.get(level).size(); i++) {
                memory[index++] = triangle.get(level).get(i) + Math.min(memory[i], memory[i + 1]);
            }
        }

        return memory[0];
    }
}
