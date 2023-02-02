package Summer_Coding.Day_20;

public class Swap_Nodes_in_Pairs {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "val: " + val;
        }
    }

    public static void main(String[] args) {
        var app = new Swap_Nodes_in_Pairs();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode result = app.swapPairs(head);
        System.out.println(result);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode left = head;
        ListNode right = head.next;

        ListNode result = right;
        ListNode prev = null;

        while (right != null) {
            ListNode newLeft = right.next;
            right.next = left;
            left.next = newLeft;

            if (prev != null)
                prev.next = right;

            prev = left;
            left = newLeft;

            if (left != null)
                right = left.next;
            else
                right = null;
        }

        return result;
    }
}
