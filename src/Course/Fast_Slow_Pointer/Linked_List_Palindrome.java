package Course.Fast_Slow_Pointer;

import Course.Fast_Slow_Pointer.Middle_of_the_Linked_List.LinkedListNode;

public class Linked_List_Palindrome {
    public static boolean palindrome(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedListNode middle = slow;
        LinkedListNode tail = reverseLinkedList(middle);
        return isPalindrome(head, tail);
    }

    private static boolean isPalindrome(LinkedListNode head, LinkedListNode tail) {
        while (tail != null) {
            if (head.data != tail.data)
                return false;
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    private static LinkedListNode reverseLinkedList(LinkedListNode head) {
        LinkedListNode prev = null;
        while (head != null) {
            LinkedListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
