package Dailty_Problems.month_1.Day_23_01;

public class Find_the_Town_Judge {
    public static void main(String[] args) {
//        [[1,2]]
        findJudge(2, new int[][] {{1, 2}});
    }

    public static int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0)
            return 1;
        int[] count = new int[n + 1];
        for (var pair : trust) {
            count[pair[0]] -= 1;
            count[pair[1]] += 1;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] == n - 1)
                return i;
        }
        return -1;
    }
}
