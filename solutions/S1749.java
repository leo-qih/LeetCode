package solutions;

/**
 * 1749. Maximum Absolute Sum of Any Subarray
 */

public class S1749 {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0], minSum = nums[0];
        int maxAbsSum = Math.abs(nums[0]);
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(nums[i], maxSum + nums[i]);
            minSum = Math.min(nums[i], minSum + nums[i]);
            maxAbsSum = Math.max(maxAbsSum, Math.max(Math.abs(maxSum), Math.abs(minSum)));
        }

        return maxAbsSum;
    }
}
