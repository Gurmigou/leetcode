package FLG_interns.Week_2;

import Util.TreeNode;

public class Distribute_Coins_in_Binary_Tree {
    int steps;

    public int distributeCoins(TreeNode root) {
        steps = 0;
        traverse(root);
        return steps;
    }

    private int traverse(TreeNode node) {
        if (node == null)
            return 0;

        int leftCoins = traverse(node.left);
        int rightCoins = traverse(node.right);
        steps += Math.abs(leftCoins) + Math.abs(rightCoins);
        return leftCoins + rightCoins + node.val - 1;
    }
}
