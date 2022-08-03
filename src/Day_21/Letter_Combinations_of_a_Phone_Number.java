package Day_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return Collections.emptyList();

        String[] keys = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> resultList = new ArrayList<>();
        backtracking(digits.toCharArray(), "", resultList, keys);
        return resultList;
    }

    private void backtracking(char[] digits, String result, List<String> resultList, String[] keys) {
        if (digits.length == result.length()) {
            resultList.add(result);;
        }

        int digit = digits[result.length()] - '0';

        for (char c : keys[digit].toCharArray()) {
            backtracking(digits, result + c, resultList, keys);
        }
    }
}
