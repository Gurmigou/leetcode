package Summer_Coding.Day_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Generate_Parentheses {
    public static void main(String[] args) {
        var app = new Generate_Parentheses();
        List<String> result = app.generateParenthesis(3);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {
        var result = new ArrayList<String>();
        var stack = new Stack<Character>();
        backtracking(result, 0, 0, n, stack);
        return result;
    }

    public void backtracking(List<String> result, int openN, int closeN, int n, Stack<Character> stack) {
        if (openN == closeN && closeN == n) {
            var sb = new StringBuilder();
            for (char c : stack)
                sb.append(c);
            result.add(sb.toString());
            return;
        }

        if (openN < n) {
            stack.push('(');
            backtracking(result, openN + 1,  closeN, n, stack);
            stack.pop();
        }

        if (closeN < openN) {
            stack.push(')');
            backtracking(result, openN, closeN + 1, n, stack);
            stack.pop();
        }
    }
}
