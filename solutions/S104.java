package solutions;

import models.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 */

public class S104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
