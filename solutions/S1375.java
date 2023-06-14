package solutions;

/**
 * 1375. Number of Times Binary String Is Prefix-Aligned
 */
public class S1375 {
    public int numTimesAllBlue(int[] flips) {
        int res = 0, lMax = 0, n = flips.length;
        for (int i = 1; i <= n; i++) {
            lMax = Math.max(lMax, flips[i - 1]);
            if (lMax == i)
                res++;
        }

        return res;
    }
}