package solutions;

import java.util.Arrays;

/**
 * 1494. Parallel Courses II
 */

public class S1494 {
    // private int[] pre, memo;
    // private int k, allCourses;

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        // this.k = k;
        // pre = new int[n];
        // for (int[] relation : relations) {
        //     pre[relation[1] - 1] |= 1 << (relation[0] - 1);
        // }
        // memo = new int[1 << n];
        // Arrays.fill(memo, -1);
        // allCourses = (1 << n) - 1;

        // return dfs(allCourses);

        int[] pre = new int[n];
        for (int[] relation : relations) {
            pre[relation[1] - 1] |= 1 << (relation[0] - 1);
        }
        int allCourses = (1 << n) - 1;
        int dp[] = new int[1 << n];
        for (int i = 1; i <= allCourses; i++) {
            int curSemCourses = 0, learnedCourses = i ^ allCourses;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0 && (pre[j] | learnedCourses) == learnedCourses) {
                    curSemCourses |= 1 << j;
                }
            }
            if (Integer.bitCount(curSemCourses) <= k) {
                dp[i] = dp[i ^ curSemCourses] + 1;
                continue;
            }
            int res = Integer.MAX_VALUE;
            for (int j = curSemCourses; j > 0; j = (j - 1) & curSemCourses) {
                if (Integer.bitCount(j) == k) {
                    res = Math.min(res, dp[i ^ j] + 1);
                }
            }
            dp[i] = res;
        }

        return dp[allCourses];
    }

    // private int dfs(int remainCourses) {
    //     if (remainCourses == 0) return 0;
    //     if (memo[remainCourses] != -1) return memo[remainCourses];

    //     int curSemCourses = 0, learnedCourses = remainCourses ^ allCourses;
    //     for (int j = 0; j < n; j++) {
    //         if ((remainCourses >> j & 1) > 0 && (pre[j] | learnedCourses) == learnedCourses) {
    //             curSemCourses |= 1 << j;
    //         }
    //     }

    //     if (Integer.bitCount(curSemCourses) <= k) {
    //         memo[remainCourses] = dfs(remainCourses ^ curSemCourses);
    //         return memo[remainCourses];
    //     }

    //     int res = Integer.MAX_VALUE;
    //     for (int j = curSemCourses; j > 0; j = (j - 1) & curSemCourses) {
    //         if (Integer.bitCount(j) == k) {
    //             res = Math.min(res, dfs(remainCourses ^ j) + 1);
    //         }
    //     }
    //     memo[remainCourses] = res;

    //     return res;
    // }
}
