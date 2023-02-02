package Summer_Coding.Day_23;

public class Element_Appearing_More_Than_25_In_Sorted_Array {
    public int findSpecialInteger(int[] arr) {
        int lowerBound = arr.length / 4;
        int index = 0;
        while (index < arr.length) {
            int count = 0;
            int cur = arr[index];
            while (index < arr.length && arr[index] == cur) {
                count++;
                index++;
            }
            if (count > lowerBound)
                return cur;
        }
        return arr[0];
    }
}
