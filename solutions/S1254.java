package solutions;

public class S1254 {
    private boolean isClosed;
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    isClosed = true;
                    dfs(grid, i, j, m, n);
                    if (isClosed) res++;
                }
            }
        }

        return res;
    }

    public void dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;

        if (grid[i][j] == 0) {
            if (i == 0 || i == m - 1 || j == 0 || j == n - 1) isClosed = false;
            grid[i][j] = 2;
            for (int[] dir : dirs) {
                dfs(grid, i + dir[0], j + dir[1], m, n);
            }
        }
    }
}
