package solutions;

import models.TreeNode;

/**
 * 700. Search in a Binary Search Tree
 */

public class S700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
