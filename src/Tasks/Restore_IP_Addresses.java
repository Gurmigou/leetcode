package Tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Restore_IP_Addresses {
    public static void main(String[] args) {
        var app = new Restore_IP_Addresses();
        List<String> result = app.restoreIpAddresses("101023");
        System.out.println(result);
    }

    static final int maxDigits = 3;

    public List<String> restoreIpAddresses(String s) {
        return createIps(s, 4);
    }

    // depth: 4 -> 3 -> 2 -> 1
    private List<String> createIps(String s, int depth) {
        if (s.isEmpty() || s.length() > depth * maxDigits || (s.charAt(0) == '0' && depth == 1 && s.length() != 1)) {
            return Collections.emptyList();
        }

        List<String> subResult = new ArrayList<>();
        if (depth == 1) {
            int number = Integer.parseInt(s);
            if (number <= 255) {
                subResult.add(s);
            }
        } else {
            int combinations = s.charAt(0) == '0' ? 1 : Math.min(s.length() - depth + 1, maxDigits);
            for (int i = 0; i < combinations; i++) {
                String curNumber = s.substring(0, i + 1);
                int number = Integer.parseInt(curNumber);
                if (number > 255)
                    continue;
                List<String> ips = createIps(s.substring(i + 1), depth - 1);
                if (ips.isEmpty())
                    continue;
                for (String ip : ips) {
                    subResult.add(curNumber + "." + ip);
                }
            }
        }

        return subResult;
    }
}
