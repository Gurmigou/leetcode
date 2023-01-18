package Course.Fast_Slow_Pointer;

public class Happy_Number {
    public boolean isHappy(int n) {
        int slow = squareSumOfDigits(n);
        int fast = squareSumOfDigits(squareSumOfDigits(n));
        while (fast != 1 && fast != slow) {
            slow = squareSumOfDigits(slow);
            fast = squareSumOfDigits(squareSumOfDigits(fast));
        }
        return fast == 1;
    }

    private static int squareSumOfDigits(int n) {
        int result = 0;
        while (n != 0) {
            result += Math.pow(n % 10, 2);
            n /= 10;
        }
        return result;
    }
}
