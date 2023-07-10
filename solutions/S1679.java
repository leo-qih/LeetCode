package solutions;

import java.util.HashMap;

/**
 * 1679. Max Number of K-Sum Pairs
 */

public class S1679 {
    public int maxOperations(int[] nums, int k) {
        // Arrays.sort(nums);
        // int ops = 0;
        // for (int i = 0, j = nums.length - 1; i < j;) {
        //     if (nums[i] + nums[j] == k) {
        //         ops++;
        //         i++;
        //         j--;
        //     } else if (nums[i] + nums[j] > k) {
        //         j--;
        //     } else {
        //         i++;
        //     }
        // }

        // return ops;
        HashMap<Integer, Integer> numsCnt = new HashMap<>();
        int ops = 0;
        for (int num : nums) {
            int target = k - num;
            int cnt = numsCnt.getOrDefault(target, 0);
            if (cnt > 0) {
                ops++;
                numsCnt.put(target, cnt - 1);
            } else {
                numsCnt.put(num, numsCnt.getOrDefault(num, 0) + 1);
            }
        }

        return ops;
    }
}
