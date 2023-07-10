package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1926. Nearest Exit from Entrance in Maze
 */

public class S1926 {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int steps = 1;
        boolean found = false;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(entrance);
        maze[entrance[0]][entrance[1]] = '-';
        out:
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.removeFirst();
                for (int[] dir : dirs) {
                    int row = dir[0] + cell[0], col = dir[1] + cell[1];
                    if (isValid(m, n, row, col) && maze[row][col] == '.') {
                        if (isExit(m, n, row, col)) {
                            found = true;
                            break out;
                        }
                        maze[row][col] = '-';
                        queue.addLast(new int[]{row, col});
                    }
                }
            }
            steps++;
        }

        return found ? steps : -1;
    }

    public boolean isExit(int m, int n, int row, int col) {
        return row == 0 || row == m - 1 || col == 0 || col == n - 1;
    }

    public boolean isValid(int m, int n, int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
