package solutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 841. Keys and Rooms
 */

public class S841 {
   public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(0);
        int visitedCnt = 0;
        while (!queue.isEmpty()) {
            int curKey = queue.removeFirst();
            if (visited[curKey]) continue;
            visitedCnt++;
            visited[curKey] = true;
            for (int key : rooms.get(curKey)) {
                if (!visited[key]) queue.addLast(key);
            }
        }

        return visitedCnt == n;
    } 
}
