package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 822. Card Flipping Game
 */

public class S822 {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> exclude = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i])
                exclude.add(fronts[i]);
        }

        int minGoodNum = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (!exclude.contains(fronts[i])) minGoodNum = Math.min(minGoodNum, fronts[i]);
            if (!exclude.contains(backs[i])) minGoodNum = Math.min(minGoodNum, backs[i]);
        }

        return minGoodNum == Integer.MAX_VALUE ? 0 : minGoodNum;
    }
}
