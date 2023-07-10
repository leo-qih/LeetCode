package solutions;

/**
 * 338. Counting Bits
 */

public class S338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
            // res[i] = getBitCount(i);
        }

        return res;
    }

    public int getBitCount(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += (n & 1);
            n /= 2;
        }

        return cnt;
    }
}
