package Dailty_Problems.month_2.Day_17_02;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Minimum_Distance_Between_BST_Nodes {
    public int minDiffInBST(TreeNode root) {
        var sortedList = new ArrayList<Integer>();
        dfs(root, sortedList);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < sortedList.size() - 1; i++) {
            minDiff = Math.min(minDiff, sortedList.get(i + 1) - sortedList.get(i));
        }
        return minDiff;
    }

    private void dfs(TreeNode root, List<Integer> sortedList) {
        if (root == null)
            return;

        dfs(root.left, sortedList);
        sortedList.add(root.val);
        dfs(root.right, sortedList);
    }
}
