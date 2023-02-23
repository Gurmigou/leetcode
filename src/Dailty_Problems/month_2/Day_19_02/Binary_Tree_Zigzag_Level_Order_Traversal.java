package Dailty_Problems.month_2.Day_19_02;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();

        // true: left -> right
        // false: right -> left
        boolean zigzag = false;

        stack.push(root);

        while (!stack.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                level.add(cur.val);
                if (zigzag) {
                    if (cur.left != null)
                        nextStack.push(cur.left);
                    if (cur.right != null)
                        nextStack.push(cur.right);
                } else {
                    if (cur.right != null)
                        nextStack.push(cur.right);
                    if (cur.left != null)
                        nextStack.push(cur.left);
                }
            }
            stack.addAll(nextStack);
            nextStack.clear();
            zigzag = !zigzag;
            result.add(level);
        }

        return result;
    }
}
