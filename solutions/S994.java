package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 994. Rotting Oranges
 */

public class S994 {
     private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int freshCnt = 0, m = grid.length, n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) freshCnt++;
                else if (grid[i][j] == 2) {
                    queue.addLast(new int[]{i, j});
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty() && freshCnt > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coord = queue.removeFirst();
                for (int[] dir : dirs) {
                    int x = coord[0] + dir[0], y = coord[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshCnt--;
                        queue.addLast(new int[]{x, y});
                    }                    
                }
            }
            minutes++;
        }

        return freshCnt == 0 ? minutes : -1;
    }
}
