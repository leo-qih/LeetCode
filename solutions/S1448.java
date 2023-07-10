package solutions;

import models.TreeNode;

/**
 * 1448. Count Good Nodes in Binary Tree
 */

public class S1448 {
    int goodNodeCnt = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);

        return goodNodeCnt;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null) return;

        if (root.val >= max) goodNodeCnt++;
        dfs(root.left, Math.max(max, root.val));
        dfs(root.right, Math.max(max, root.val));
    }
}
