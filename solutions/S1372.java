package solutions;

import models.TreeNode;

/**
 * 1372. Longest ZigZag Path in a Binary Tree
 */

public class S1372 {
    int maxLen = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root.left, 'L', 1);
        dfs(root.right, 'R', 1);

        return maxLen;
    }

    public void dfs(TreeNode root, char prevDirection, int len) {
        if (root == null) return;

        maxLen = Math.max(maxLen, len);
        if (prevDirection == 'L') {
            dfs(root.left, 'L', 1);
            dfs(root.right, 'R', len + 1);
        } else {
            dfs(root.left, 'L', len + 1);
            dfs(root.right, 'R', 1);
        }
    }
}
