package Summer_Coding.Day_34;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int maxSquare = 0;
        while (l < r) {
            maxSquare = Math.max(maxSquare, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r++;
        }

        return maxSquare;
    }
}
