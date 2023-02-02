package Summer_Coding.Day_27;

public class Sum_of_All_Odd_Length_Subarrays {
    public static void main(String[] args) {
        var app = new Sum_of_All_Odd_Length_Subarrays();
        int i = app.sumOddLengthSubarrays(new int[]{1, 2});
        System.out.println(i);
    }

    public int sumOddLengthSubarrays(int[] arr) {
        if (arr.length == 1)
            return arr[0];

        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++)
            prefix[i] = prefix[i - 1] + arr[i];

        int l = 0;
        int r = 0;

        int nextR = 0;
        int result = 0;

        while ((r - l + 1) < arr.length) {
            l = 0;
            r = nextR;
            while (r < arr.length) {
                if (l - 1 < 0)
                    result += prefix[r];
                else
                    result += prefix[r] - prefix[l - 1];
                r++;
                l++;
            }
            nextR += 2;
        }

        return result;
    }
}
