package solutions;

import java.util.Arrays;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 */

public class S452 {
    public int findMinArrowShots(int[][] points) {
        // Arrays.sort(points, (a, b) -> {
        //     if (a[0] > b[0]) {
        //         return 1;
        //     } else {
        //         return -1;
        //     }
        // });

        // int n = points.length;
        // int[] dp = new int[n];
        // int minArrowRequired = 1;
        // Arrays.fill(dp, 1);
        // for (int i = 1; i < n; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (points[j][1] < points[i][0]) {
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //             minArrowRequired = Math.max(dp[i], minArrowRequired);
        //         }
        //     }
        // }

        // return minArrowRequired;

        Arrays.sort(points, (a, b) -> {
            if (a[1] > b[1]) {
                return 1;
            } else {
                return -1;
            }
        });

        int minArrowRequired = 1, rightBound = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (rightBound < points[i][0]) {
                rightBound = points[i][1];
                minArrowRequired++;
            }
        }
        

        return minArrowRequired;
    }
}
