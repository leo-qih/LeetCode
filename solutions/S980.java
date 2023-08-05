package solutions;

/**
 * 980. Unique Paths III
 */

public class S980 {
    static int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0, emptySquareCnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) emptySquareCnt++;
                else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        return dfs(grid, startX, startY, emptySquareCnt + 1);
    }

    private int dfs(int[][] grid, int x, int y, int left) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) return 0;
        if (grid[x][y] == 2) return left == 0 ? 1 : 0;

        int cnt = 0;
        grid[x][y] = -1;
        for (int[] dir : dirs) {
            cnt += dfs(grid, x + dir[0], y + dir[1], left - 1);
        }
        grid[x][y] = 0;

        return cnt;
    }
}
