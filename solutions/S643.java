package solutions;

/**
 * 643. Maximum Average Subarray I
 */

public class S643 {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = 0, sum = 0;

        for (int i = 0; i < k; i++) sum += nums[i];
        maxSum = Math.max(maxSum, sum);
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum / k;
    }
}
