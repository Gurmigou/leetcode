package Other_Topics.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Different_Ways_to_Add_Parentheses {
    public static void main(String[] args) {
        var app = new Different_Ways_to_Add_Parentheses();
        List<Integer> integers = app.diffWaysToCompute("0" );
        System.out.println(integers);
    }

    public List<Integer> diffWaysToCompute(String expression) {
        HashMap<Double, List<Integer>> memo = new HashMap<>();
        return executeInBrackets(expression, 0, expression.length(), memo);
    }

    // use Cantor pairing function N x N -> N
    private Double key(int a, int b) {
        return 0.5 * (a + b) * (a + b + 1) + b;
    }

    private List<Integer> executeInBrackets(String expression, int l, int r, HashMap<Double, List<Integer>> memo) {
        if (memo.containsKey(key(l, r)))
            return memo.get(key(l, r));

        List<Integer> resultList = new ArrayList<>();
        for (int i = l; i < r; i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                List<Integer> left = executeInBrackets(expression, l, i, memo);
                List<Integer> right = executeInBrackets(expression, i + 1, r, memo);

                if (expression.charAt(i) == '+') {
                    for (Integer il : left) {
                        for (Integer ir : right) {
                            resultList.add(il + ir);
                        }
                    }
                } else if (expression.charAt(i) == '-') {
                    for (Integer il : left) {
                        for (Integer ir : right) {
                            resultList.add(il - ir);
                        }
                    }
                } else {
                    for (Integer il : left) {
                        for (Integer ir : right) {
                            resultList.add(il * ir);
                        }
                    }
                }
            }
        }

        if (resultList.isEmpty()) {
            resultList.add(Integer.parseInt(expression.substring(l, r)));
        }

        memo.put(key(l, r), resultList);
        return resultList;
    }
}
