package solutions;

import java.util.Arrays;

/**
 * 392. Is Subsequence
 */

public class S392 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        // int i = 0;
        // for (int j = 0; i < n && j < m; j++) {
        //     if (s.charAt(i) == t.charAt(j)) {
        //         i++;
        //     }
        // }

        // return i == n;

        int[][] dp = new int[m + 1][26];
        Arrays.fill(dp[m], -1);

        for (int i = m - 1; i >= 0; i--) {
            int u = t.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                if (u == j) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            int u = s.charAt(i) - 'a';
            if (dp[idx][u] == -1) {
                return false;
            } else {
                idx = dp[idx][u] + 1;
            }
        }

        return true;
    }
}
