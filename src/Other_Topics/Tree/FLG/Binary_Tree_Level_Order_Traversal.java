package Other_Topics.Tree.FLG;

import Util.TreeNode;

import java.util.*;

public class Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        // traverse tree using bfs
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode levelNode = queue.poll();
                levelList.add(levelNode.val);

                if (levelNode.left != null)
                    queue.add(levelNode.left);
                if (levelNode.right != null)
                    queue.add(levelNode.right);
            }
            result.add(levelList);
        }

        return result;
    }
}
