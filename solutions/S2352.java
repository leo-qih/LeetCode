package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 2352. Equal Row and Column Pairs
 */

public class S2352 {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rows = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[0].length; j++) {
                sb.append(grid[i][j]).append(",");
            }
            String s = sb.toString();
            rows.put(s, rows.getOrDefault(s, 0) + 1);
        }

        int cnt = 0;
        for (int i = 0; i < grid[0].length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                sb.append(grid[j][i]).append(",");
            }
            cnt += rows.getOrDefault(sb.toString(), 0);
        }

        return cnt;
    }
}
