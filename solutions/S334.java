package solutions;

/**
 * 334. Increasing Triplet Subsequence
 */

public class S334 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int left = nums[0], mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > mid) {
                return true;
            } else if (num > left) {
                mid = num;
            } else {
                left = num;
            }
        }

        return false;
    }
}
