package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 735. Asteroid Collision
 */

public class S735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int aster : asteroids) {
            boolean exploded = false;
            if (aster < 0) {
                int size = -aster;
                while (!exploded && !stack.isEmpty() && stack.peek() > 0) {
                    if (size <= stack.peek()) exploded = true;
                    if (size >= stack.peek()) stack.pop();
                }
            }
            if (!exploded) stack.push(aster);
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
