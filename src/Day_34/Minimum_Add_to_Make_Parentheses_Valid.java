package Day_34;

public class Minimum_Add_to_Make_Parentheses_Valid {
    public int minAddToMakeValid(String s) {
        int balance = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            balance += (c == '(') ? 1 : - 1;
            if (balance == -1) {
                balance = 0;
                result += 1;
            }
        }
        return result + balance;
    }
}
