package Other_Topics.LinkedList;

import Util.ListNode;
import Util.Pair;

public class Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1 [prev_left] -> 2 [left] -> 3 -> 4 -> 5
        //
        // 2 -> 3 -> 4  =>  2 <- 3 <- 4 [H] 5 [next_H]
        // prev_left -> H
        // left -> next_H
        //
        // if prev_left is none -> head = H
        // if next_H is none -> do nothing

        if (left == right)
            return head;

        ListNode prevLeft = null;
        ListNode leftNode = head;
        for (int i = 0; i < left - 1; i++) {
            prevLeft = leftNode;
            leftNode = leftNode.next;
        }

        // pair.first = H
        // pair.second = next_H
        var sublistPair = reverseLinkedList(leftNode, (right - left + 1));

        if (prevLeft != null) {
            prevLeft.next = sublistPair.first;
        } else {
            head = sublistPair.first;
        }

        if (sublistPair.second != null) {
            leftNode.next = sublistPair.second;
        }

        return head;
    }

    public Pair<ListNode, ListNode> reverseLinkedList(ListNode head, int length) {
        ListNode prev = null;
        ListNode cur = head;
        // 1 -> 2 -> 3 -> 4 -> 5
        //      ------ length = 2
        for (int i = 0; i < length; i++) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return Pair.of(prev, cur);
    }

}
