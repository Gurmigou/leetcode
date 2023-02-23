package Dailty_Problems.month_2.Day_16_02;

import Util.TreeNode;

public class Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
