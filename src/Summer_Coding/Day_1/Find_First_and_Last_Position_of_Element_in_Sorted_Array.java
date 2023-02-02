package Summer_Coding.Day_1;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearchHelper(nums, target, true);
        int end = binarySearchHelper(nums, target, false);
        return new int[] {start, end};
    }

    // leftBias == true => leftBias;
    // leftBias == false => rightBias
    public int binarySearchHelper(int[] nums, int target, boolean leftBias) {
        int left = 0;
        int right = nums.length - 1;

        int i = -1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (target < nums[middle])
                right = middle - 1;
            else if (target > nums[middle])
                left = middle + 1;
            else {
                i = middle;
                if (leftBias) // go to left part of the array
                    right = middle - 1;
                else // go to right part of the array
                    left = middle + 1;
            }
        }
        return i;
    }
}
