package Dailty_Problems.Day_09_01;

public class Trapping_Rain_Water {
    public static void main(String[] args) {
        var app = new Trapping_Rain_Water();
        int result = app.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(result);
    }

    public int trap(int[] height) {
        if (height.length == 0)
            return 0;

        int l = 0;
        int r = height.length - 1;

        int maxLeft = height[l];
        int maxRight = height[r];

        int result = 0;

        while (l < r) {
            if (maxLeft <= maxRight) {
                l++;
                result += Math.max(maxLeft - height[l], 0);
                maxLeft = Math.max(maxLeft, height[l]);
            } else {
                r--;
                result += Math.max(maxRight - height[r], 0);
                maxRight = Math.max(maxRight, height[r]);
            }
        }

        return result;
    }
}
