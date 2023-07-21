package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1499. Max Value of Equation
 */

public class S1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        // yi + yj + |xi - xj|, 1 <= i < j <= points.length
        // => yi + yj + xj - xi
        // => (xj + yj) + (yi - xi)
        // for points[j], find points[i] with the maximum (yi - xi) where i < j and
        // |xi - xj| <= k => xj - xi <= k

        int maxValue = Integer.MIN_VALUE;
        // {xi, yi - xi} monotonic queue where yi - xi is strictly decreasing
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            while (!queue.isEmpty() && x - queue.getFirst()[0] > k) {
                queue.removeFirst();
            }

            if (!queue.isEmpty())
                maxValue = Math.max(maxValue, x + y + queue.getFirst()[1]);

            while (!queue.isEmpty() && y - x >= queue.getLast()[1]) {
                queue.removeLast();
            }

            queue.addLast(new int[] { x, y - x });
        }

        return maxValue;
    }
}
