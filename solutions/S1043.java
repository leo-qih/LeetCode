package solutions;

// import java.util.Arrays;

/**
 * 1043. Partition Array for Maximum Sum
 */
public class S1043 {
    // private int[] arr, memo;
    // private int k;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        // this.arr = arr;
        // this.k = k;
        // int n = arr.length;
        // memo = new int[n];
        // Arrays.fill(memo, -1);
        // return dfs(n - 1);

        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i, max = 0; i - j + 1 <= k && j >= 0; j--) {
                max = Math.max(max, arr[j]);
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + max * (i - j + 1));
            }
        }

        return dp[n];
    }

    // public int dfs(int i) {
    //     if (i < 0) return 0;
    //     if (memo[i] != -1) return memo[i];

    //     int res = 0;
    //     for (int j = i, max = 0; i - j + 1 <= k && j >= 0; j--) {
    //         max = Math.max(max, arr[j]);
    //         res = Math.max(res, dfs(j - 1) + max * (i - j + 1));
    //     }
    //     memo[i] = res;

    //     return res;
    // }
}