package solutions;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * 2569. Handling Sum Queries After Update
 */

public class S2569 {
    // better to use segment tree
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        long sum = 0;
        BitSet bitSet = new BitSet(n);
        for (int i = 0; i < n; i++) {
            sum += nums2[i];
            if (nums1[i] == 1) bitSet.set(i);
        }

        List<Long> resList = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                bitSet.flip(query[1], query[2] + 1);
            } else if (query[0] == 2) {
                sum += (long) bitSet.cardinality() * query[1];
            } else {
                resList.add(sum);
            }
        }

        return resList.stream().mapToLong(Long::longValue).toArray();
    }
}
