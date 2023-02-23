package Other_Topics.Tree.FLG;

import Util.TreeNode;

public class Binary_Tree_Maximum_Path_Sum {
    private int maximum;
    private int maximumSingleValue;
    private boolean anyNonNegative = false;

    public int maxPathSum(TreeNode root) {
        maximum = Integer.MIN_VALUE;
        maximumSingleValue = root.val;
        dfs(root);

        return anyNonNegative ? maximum : maximumSingleValue;
    }

    private int dfs(TreeNode cur) {
        if (cur == null)
            return 0;

        updateState(cur);

        int leftSubtree = Math.max(dfs(cur.left), 0);
        int rightSubtree = Math.max(dfs(cur.right), 0);

        maximum = Math.max(maximum, cur.val + leftSubtree + rightSubtree);
        return cur.val + Math.max(leftSubtree, rightSubtree);
    }

    private void updateState(TreeNode cur) {
        if (!anyNonNegative) {
            if (cur.val >= 0)
                anyNonNegative = true;
            else
                maximumSingleValue = Math.max(maximumSingleValue, cur.val);
        }
    }
}
