package Summer_Coding.Day_19;

public class Add_Two_Numbers {
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
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode resultHead = dummy;
        int overflow = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                int sum = l2.val + overflow;
                resultHead.next = new ListNode(sum % 10);
                l2 = l2.next;
                overflow = sum / 10;
            } else if (l2 == null) {
                int sum = l1.val + overflow;
                resultHead.next = new ListNode(sum % 10);
                l1 = l1.next;
                overflow = sum / 10;
            } else {
                int sum = l1.val + l2.val + overflow;

                resultHead.next = new ListNode(sum % 10);

                overflow = sum / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            resultHead = resultHead.next;
        }

        if (overflow > 0)
            resultHead.next = new ListNode(overflow);

        return dummy.next;
    }
}
