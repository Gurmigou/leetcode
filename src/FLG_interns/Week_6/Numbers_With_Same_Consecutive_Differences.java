package FLG_interns.Week_6;

import java.util.ArrayList;
import java.util.List;

public class Numbers_With_Same_Consecutive_Differences {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(resultList, i, n, k);
        }
        int[] result = new int[resultList.size()];
        int index = 0;
        for (int password : resultList) {
            result[index++] = password;
        }
        return result;
    }

    private void dfs(List<Integer> resultList, int input, int rem, int k) {
        if (rem == 1) {
            resultList.add(input);
            return;
        }

        int digit = input % 10;
        if (digit - k >= 0) {
            dfs(resultList, input * 10 + (digit - k), rem - 1, k);
        }
        if (k != 0 && digit + k < 10) {
            dfs(resultList, input * 10 + (digit + k), rem - 1, k);
        }
    }
}
