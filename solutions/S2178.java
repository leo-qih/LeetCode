package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 2178. Maximum Split of Positive Even Integers
 */
public class S2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if ((finalSum & 1) == 1) return res;

        for (long i = 2; i <= finalSum; i += 2) {
            finalSum -= i;
            res.add(i);
        }
        res.add(res.remove(res.size() - 1) + finalSum);

        return res;
    }
}