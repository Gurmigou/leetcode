package Day_18;

public class Merge_Two_Sorted_Lists {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            else if (list2 == null) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else {
                if (list1.val < list2.val) {
                    cur.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    cur.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
