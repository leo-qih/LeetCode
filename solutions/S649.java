package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 649. Dota2 Senate
 */

public class S649 {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Deque<Integer> radiant = new ArrayDeque<>();
        Deque<Integer> dire = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                radiant.addLast(i);
            } else {
                dire.addLast(i);
            }
        }
        
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            if (radiant.getFirst() < dire.getFirst()) {
                dire.removeFirst();
                radiant.addLast(radiant.removeFirst() + n);
            } else {
                radiant.removeFirst();
                dire.addLast(dire.removeFirst() + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
