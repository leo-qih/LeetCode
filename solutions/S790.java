package solutions;

/**
 * 790. Domino and Tromino Tiling
 */

public class S790 {
    static final int MOD = (int)1e9 + 7;

    public int numTilings(int n) {
        int[][] dp = new int[n][4];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][3]) % MOD;
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
        }

        return dp[n - 1][1];
    }
}
