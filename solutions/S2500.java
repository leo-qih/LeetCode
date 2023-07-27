package solutions;

import java.util.Arrays;

/**
 * 2500. Delete Greatest Value in Each Row
 */

public class S2500 {
    public int deleteGreatestValue(int[][] grid) {
        int res = 0, n = grid[0].length;
        for (int[] row : grid) {
            Arrays.sort(row);
        }
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int[] row : grid) {
                max = Math.max(max, row[i]);
            }
            res += max;
        }

        return res;
    }
}
