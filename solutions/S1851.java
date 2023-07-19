package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1851. Minimum Interval to Include Each Query
 */

public class S1851 {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int queryLen = queries.length, intervalLen = intervals.length;
        Integer[] queryIdxes = new Integer[queryLen];
        for (int i = 0; i < queryLen; i++) queryIdxes[i] = i;
        Arrays.sort(queryIdxes, (a, b) -> queries[a] - queries[b]);

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // {len, left, right}
        int[] res = new int[queryLen];
        int intervalIdx = 0;
        for (int qIdx : queryIdxes) {
            while (intervalIdx < intervalLen && queries[qIdx] >= intervals[intervalIdx][0]) {
                pq.offer(new int[]{intervals[intervalIdx][1] - intervals[intervalIdx][0] + 1, intervals[intervalIdx][0], intervals[intervalIdx][1]});
                intervalIdx++;
            }
            while (!pq.isEmpty() && queries[qIdx] > pq.peek()[2]) {
                pq.poll();
            }

            res[qIdx] = pq.isEmpty() ? -1 : pq.peek()[0];
        }

        return res;
    }
}
