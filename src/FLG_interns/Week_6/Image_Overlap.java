package FLG_interns.Week_6;

public class Image_Overlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxCount = 0;

        for (int shiftRow = -n + 1; shiftRow < n; shiftRow++) {
            for (int shiftColumn = -n + 1; shiftColumn < n; shiftColumn++) {
                int counted = countOverlapping(img1, img2, shiftRow, shiftColumn, n);
                maxCount = Math.max(maxCount, counted);
            }
        }

        return maxCount;
    }

    private int countOverlapping(int[][] img1, int[][] img2, int shiftRow, int shiftColumn, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + shiftRow >= n || j + shiftColumn >= n ||
                        i + shiftRow < 0 || j + shiftColumn < 0)
                    continue;
                if (img1[i + shiftRow][j + shiftColumn] == 1 && img2[i][j] == 1) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
