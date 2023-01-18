package Course.Two_Pointers;

public class Trapping_Rain_Water {
    public static void main(String[] args) {
        var app = new Trapping_Rain_Water();
        app.trap(new int[] {4, 2, 3});
    }

    public int trap(int[] height) {
        int result = 0;

        int nextStop = -1;
        for (int i = 0; i < height.length; i++) {
            if (i == nextStop) {
                nextStop = -1;
            }

            if (nextStop != -1) {
                result -= height[i];
                continue;
            }

            if (height[i] == 0)
                continue;

            for (int j = i + 1; j < height.length; j++) {
                if (height[j] >= height[i]) {
                    result += (j - i - 1) * Math.min(height[i], height[j]);
                    nextStop = j;
                    break;
                }
            }
        }

        return result;
    }
}
