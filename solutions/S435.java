package solutions;

import java.util.Arrays;

/**
 * 435. Non-overlapping Intervals
 */

public class S435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });

        int rightBound = intervals[0][1], numOfRemoval = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (rightBound > intervals[i][0]) {
                numOfRemoval++;
            } else {
                rightBound = intervals[i][1];
            }
        }

        return numOfRemoval;
    }
}
