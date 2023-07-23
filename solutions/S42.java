package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. Trapping Rain Water
 */

public class S42 {
    public int trap(int[] height) {
        int numOfWaterTrapped = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.getLast()]) {
                int mid = stack.removeLast();
                if (!stack.isEmpty()) {
                    int heightDiff = Math.min(height[stack.getLast()], height[i]) - height[mid];
                    if (heightDiff > 0) numOfWaterTrapped += heightDiff * (i - stack.getLast() - 1);
                }
            }
            stack.addLast(i);
        }

        return numOfWaterTrapped;
    }
}