package solutions;

import java.util.HashSet;
import java.util.Set;


/**
 * 874. Walking Robot Simulation
 */
public class S874 {
    static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(mapCoordToInteger(obstacle[0], obstacle[1]));
        }

        int curDir = 0, curX = 0, curY = 0, maxED = 0; // 0 -> north, 1 -> east, 2-> south, 3 -> west
        for (int command : commands) {
            if (command == -2) curDir = (curDir - 1 + 4) % 4;
            else if (command == -1) curDir = (curDir + 1) % 4;
            else {
                for (int i = 0; i < command; i++) {
                    int[] dir = DIRS[curDir];
                    if (!obstacleSet.contains(mapCoordToInteger(curX + dir[0], curY + dir[1]))) {
                        curX += dir[0];
                        curY += dir[1];
                    } else {
                        break;
                    }
                }
                
                maxED = Math.max(maxED, curX * curX + curY * curY);
            }
        }

        return maxED;
    }

    public int mapCoordToInteger(int x, int y) {
        // -30000 <= x, y <= 30000, so the max(y2 - y1) <= 60000
        return x * 60010 + y;
    }
}
