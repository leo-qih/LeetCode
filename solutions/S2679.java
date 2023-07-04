package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2679. Sum in a Matrix
 */

public class S2679 {
    public int matrixSum(int[][] nums) {
        int score = 0, m = nums.length, n = nums[0].length;

        // PriorityQueue<Integer>[] rows = new PriorityQueue[m];
        // for (int i = 0; i < m; i++) {
        //     rows[i] = new PriorityQueue<>((a, b) -> b - a);
        //     for (int j = 0; j < n; j++) {
        //         rows[i].add(nums[i][j]);
        //     }
        // }

        // for (int i = 0; i < n; i++) {
        //     int maxVal = 0;
        //     for (int j = 0; j < m; j++) {
        //         maxVal = Math.max(maxVal, rows[j].poll());
        //     }
        //     score += maxVal;
        // }

        for (int[] row : nums) {
            Arrays.sort(row);
        }

        for (int i = n - 1; i >= 0; i--) {
            int maxVal = 0;
            for (int j = 0; j < m; j++) {
                maxVal = Math.max(maxVal, nums[j][i]);
            }
            score += maxVal;
        }

        return score;
    }
}
