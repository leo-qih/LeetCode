package solutions;

import java.util.Arrays;

/**
 * 1262. Greatest Sum Divisible by Three
 */
public class S1262 {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][3];
        dp[0][1] = dp[0][2] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i + 1][j] = Math.max(dp[i][j], dp[i][(j + 3 - nums[i] % 3) % 3] + nums[i]);
            }
        }

        return dp[n][0];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4};
        S1262 s = new S1262();
        System.out.println(s.maxSumDivThree(arr));
    }
}