package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 901. Online Stock Span
 */

public class S901 {
    // mono stack where price is stored in desending order from bottom to top
    // int[0] is price, int[1] is day count
    Deque<int[]> stack;

    public S901() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int days = 1;
        while (!stack.isEmpty() && price >= stack.getLast()[0]) {
            days += stack.removeLast()[1];
        }
        stack.addLast(new int[]{price, days});

        return days;
    }
}
