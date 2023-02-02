package OA_2022.TikTok_OA;

import java.util.Stack;

public class Minimum_Remove_to_Make_Valid_Parentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(')
                    stack.pop();
                else
                    stack.push(i);
            }
        }
        StringBuilder sb = new StringBuilder(s);
        while (!stack.isEmpty())
            sb.deleteCharAt(stack.pop());
        return sb.toString();
    }
}
