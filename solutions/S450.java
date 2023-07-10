package solutions;

import models.TreeNode;

/**
 * 450. Delete Node in a BST
 */

public class S450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            TreeNode target = root.right;
            while (target.left != null) target = target.left;
            target.left = root.left;
            return root.right;
        }
        
        return root;
    }
}
