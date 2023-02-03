package Other_Topics.Monotonic_Stack;

import java.util.Stack;

public class Remove_K_Digits {
    public static void main(String[] args) {
        var app = new Remove_K_Digits();
        app.removeKdigits("112", 1);
    }

    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";

        var monotonicStack = new Stack<Integer>();
        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';
            while (!monotonicStack.isEmpty() && monotonicStack.peek() > cur && k > 0) {
                monotonicStack.pop();
                k--;
            }
            monotonicStack.push(cur);
        }

        while (!monotonicStack.isEmpty() && k > 0) {
            monotonicStack.pop();
            k--;
        }

        var builder = new StringBuilder();
        while (!monotonicStack.isEmpty()) {
            builder.append((char) (monotonicStack.pop() + '0'));
        }
        builder.reverse();

        var preResult = builder.toString();
        if (preResult.charAt(0) != '0')
            return preResult;

        for (int i = 1; i < preResult.length(); i++) {
            if (preResult.charAt(i) != '0')
                return preResult.substring(i);
        }

        return "0";
    }
}
