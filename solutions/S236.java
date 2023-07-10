package solutions;

import models.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 */

public class S236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) {
            return root;
        } else if (l == null) {
            return r;
        } else {
            return l;
        }
    }
}
