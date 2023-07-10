package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class S739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // mono stack, with temperatures[i] desending from bottom to top
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.getLast()]) {
                int idx = stack.removeLast();
                res[idx] = i - idx;
            }
            stack.addLast(i);
        }

        return res;
    }
}
