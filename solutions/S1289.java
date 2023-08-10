package solutions;

/**
 * 1289. Minimum Falling Path Sum II
 */

public class S1289 {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        int minSum = 0, minIdx = -1, secondMinSum = 0;
        for (int i = 0; i < n; i++) {
            int curMinSum = Integer.MAX_VALUE, curMinIdx = -1, curSecondMinSum = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int curSum = (minIdx == j ? secondMinSum : minSum) + grid[i][j];
                if (curSum < curMinSum) {
                    curSecondMinSum = curMinSum;
                    curMinSum = curSum;
                    curMinIdx = j;
                } else if (curSum < curSecondMinSum) {
                    curSecondMinSum = curSum;
                }
            }
            minSum = curMinSum;
            minIdx = curMinIdx;
            secondMinSum = curSecondMinSum;
        }

        return minSum;
    }
}
