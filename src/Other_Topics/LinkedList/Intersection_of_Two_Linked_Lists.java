package Other_Topics.LinkedList;

// Task 160: https://leetcode.com/problems/intersection-of-two-linked-lists/
public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = length(headA);
        int lengthB = length(headB);

        int delta = Math.abs(lengthA - lengthB);

        ListNode lower;
        ListNode higher;
        if (lengthA < lengthB) {
            lower = headA;
            higher = headB;
        } else {
            lower = headB;
            higher = headA;
        }

        for (int i = 0; i < delta; i++) {
            higher = higher.next;
        }

        while (lower != null && higher != null) {
            if (lower == higher)
                return lower;
            lower = lower.next;
            higher = higher.next;
        }
        return null;
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
