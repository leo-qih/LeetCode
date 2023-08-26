package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 2682. Find the Losers of the Circular Game
 */

public class S2682 {
    public int[] circularGameLosers(int n, int k) {
        Set<Integer> set = new HashSet<>();
        for (int curFriend = 0, steps = k; !set.contains(curFriend); steps += k) {
            set.add(curFriend);
            curFriend = (curFriend + steps) % n;
        }

        if (set.size() >= n) return new int[0];
        int[] losers = new int[n - set.size()];
        for (int i = 0, idx = 0; i < n; i++) {
            if (!set.contains(i))
                losers[idx++] = i + 1;
        }

        return losers;
    }
}
