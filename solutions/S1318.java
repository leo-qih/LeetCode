package solutions;

/**
 * 1318. Minimum Flips to Make a OR b Equal to c
 */

public class S1318 {
    public int minFlips(int a, int b, int c) {
        int numFlips = 0;
        while (a != 0 || b != 0 || c != 0) {
            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0) {
                    numFlips++;
                }
            } else {
                if ((a & 1) == 1) numFlips++;
                if ((b & 1) == 1) numFlips++;
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }

        return numFlips;
    }
}
