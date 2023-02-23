package Other_Topics.Tree.FLG;

import Other_Topics.LinkedList.Intersection_of_Two_Linked_Lists.ListNode;
import Util.TreeNode;

public class Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode start, ListNode end) {
        if (start == end)
            return null;
        ListNode slow = start;
        ListNode fast = start;
        while (fast != null && fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow;
        TreeNode treeNode = new TreeNode(middle.val);

        treeNode.left = buildTree(start, middle);
        treeNode.right = buildTree(middle.next, end);
        return treeNode;
    }
}
