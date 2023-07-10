package solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import models.TreeNode;

/**
 * 199. Binary Tree Right Side View
 */
public class S199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.removeFirst();
                if (i == size - 1) res.add(p.val);
                if (p.left != null) queue.addLast(p.left);
                if (p.right != null) queue.addLast(p.right);
            }
        }

        return res;
    }
}
