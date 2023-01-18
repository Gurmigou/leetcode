package Course.Fast_Slow_Pointer;

import java.util.HashSet;

public class Linked_List_Cycle {
    public boolean hasCycleWithSet(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null && !set.contains(cur)) {
            set.add(cur);
            cur = cur.next;
        }
        return cur != null;
    }

    public boolean hasCycleWithSlowAndFastPointers(ListNode head) {
        ListNode slow = head;
        if (slow == null || slow.next == null)
            return false;
        ListNode fast = slow.next;
        while (fast != null && slow != fast) {
            if (fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow == fast;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
