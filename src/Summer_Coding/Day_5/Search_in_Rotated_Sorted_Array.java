package Summer_Coding.Day_5;

public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3};
        int target = 3;

        var app = new Search_in_Rotated_Sorted_Array();
        int result = app.search(arr, target);

        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int partitioner = nums[right];

        while (left <= right) {
            int middle = (left + right) / 2;
            int middleValue = nums[middle];

            if (target == middleValue)
                return middle;

            // left part of the array
            if (middleValue > partitioner) {
                if (target < nums[0])
                    left = middle + 1;
                else {
                    if (target < middleValue)
                        right = middle - 1;
                    else
                        left = middle + 1;
                }
            }
            // right part of the array
            else {
                if (target > partitioner)
                    right = middle - 1;
                else {
                    if (target < middleValue)
                        right = middle - 1;
                    else
                        left = middle + 1;
                }
            }
        }

        return -1;
    }
}
