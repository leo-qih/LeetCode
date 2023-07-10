package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

import models.TreeNode;

/**
 * 1161. Maximum Level Sum of a Binary Tree
 */

public class S1161 {
    public int maxLevelSum(TreeNode root) {
        int minLevelWithMaxSum = 1, maxSum = Integer.MIN_VALUE, level = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.removeFirst();
                sum += p.val;
                if (p.left != null) queue.addLast(p.left);
                if (p.right != null) queue.addLast(p.right);
            }
            if (sum > maxSum) {
                maxSum = sum;
                minLevelWithMaxSum = level;
            }
        }

        return minLevelWithMaxSum;
    }
}
