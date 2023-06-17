package solutions;

/**
 * 2481. Minimum Cuts to Divide a Circle
 */

public class S2481 {
    public int numberOfCuts(int n) {
        if (n == 1) return 0;

        return n % 2 == 0 ? n / 2 : n;
    }
}
