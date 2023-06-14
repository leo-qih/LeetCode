package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 2475. Number of Unequal Triplets in Array
 */

public class S2475 {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        int n = nums.length, res = 0, leftCnt = 0;
        for (int midCnt : cnt.values()) {
            int rightCnt = n - leftCnt - midCnt;
            res += leftCnt * midCnt * rightCnt;
            leftCnt += midCnt;
        }

        return res;
    }
}
