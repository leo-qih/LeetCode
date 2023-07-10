package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2542. Maximum Subsequence Score
 */

public class S2542 {
   public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] idxMapNums2 = new Integer[n];
        for (int i = 0; i < n; i++) idxMapNums2[i] = i;
        Arrays.sort(idxMapNums2, (a, b) -> nums2[b] - nums2[a]);

        long res = 0L;
        long sumOfSubSeq1 = 0L;
        PriorityQueue<Integer> minHeadSubSeq1 = new PriorityQueue<>();
        for (int i = 0; i < k - 1; i++) {
            sumOfSubSeq1 += nums1[idxMapNums2[i]];
            minHeadSubSeq1.offer(nums1[idxMapNums2[i]]);
        }

        for (int i = k - 1; i < n; i++) {
            int idx = idxMapNums2[i];
            sumOfSubSeq1 += nums1[idx];
            minHeadSubSeq1.offer(nums1[idx]);

            res = Math.max(res, sumOfSubSeq1 * nums2[idx]);

            sumOfSubSeq1 -= minHeadSubSeq1.poll();
        }

        return res;
    } 
}
