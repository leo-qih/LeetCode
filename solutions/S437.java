package solutions;

import java.util.HashMap;
import java.util.Map;

import models.TreeNode;

/**
 * 437. Path Sum III
 */

public class S437 {
    int cnt = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> sumCnt = new HashMap<>();
        sumCnt.put(0L, 1);
        dfs(root, sumCnt, 0L, targetSum);

        return cnt;
    }

    public void dfs(TreeNode root, Map<Long, Integer> sumCnt, long pathSum, int targetSum) {
        if (root == null) return;

        pathSum += root.val;
        cnt += sumCnt.getOrDefault(pathSum - targetSum, 0);

        sumCnt.put(pathSum, sumCnt.getOrDefault(pathSum, 0) + 1);
        dfs(root.left, sumCnt, pathSum, targetSum);
        dfs(root.right, sumCnt, pathSum, targetSum);
        sumCnt.put(pathSum, sumCnt.getOrDefault(pathSum, 0) - 1);
    }
}
