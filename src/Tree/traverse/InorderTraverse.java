package Tree.traverse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraverse {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalHelper(result, root);
        return result;
    }

    private void inorderTraversalHelper(List<Integer> list, TreeNode root) {
        if (root == null)
            return;
        inorderTraversalHelper(list, root.left);
        list.add(root.val);
        inorderTraversalHelper(list, root.right);
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            TreeNode top = stack.pop();
            list.add(top.val);

            node = top.right;
        }

        return list;
    }
}
























