package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 933. Number of Recent Calls
 */

public class S933 {
    Deque<Integer> requests;

    public S933() {
        requests = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        requests.addLast(t);
        while (!requests.isEmpty() && t - requests.getFirst() > 3000) {
            requests.removeFirst();
        }

        return requests.size();
    }
}
