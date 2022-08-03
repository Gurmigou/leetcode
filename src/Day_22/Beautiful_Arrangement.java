package Day_22;

public class Beautiful_Arrangement {
    public static void main(String[] args) {
        var app = new Beautiful_Arrangement();
        int result = app.countArrangement(3);
        System.out.println(result);
    }

    public int countArrangement(int n) {
        boolean[] used = new boolean[n];
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += backtracking(n, i, 1, used);
        }
        return result;
    }

    public int backtracking(int n, int number, int i, boolean[] used) {
        if (i == n && rule(number, i))
            return 1;

        if (!rule(number, i))
            return 0;

        used[number - 1] = true;

        int index = 1;
        int result = 0;
        for (boolean val : used) {
            if (!val) {
                result += backtracking(n, index, i + 1, used);
            }
            index++;
        }

        used[number - 1] = false;
        return result;
    }

    private boolean rule(int number, int i) {
        return number % i == 0 || i % number == 0;
    }
}
