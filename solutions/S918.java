package solutions;

/**
 * 918. Maximum Sum Circular Subarray
 */

public class S918 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

       int maxSum = 0, globalMaxSum = Integer.MIN_VALUE, totalSum = 0;
       int minSum = 0, globalMinSum = Integer.MAX_VALUE; // min sum exclude nums[0] and nums[nums.lengh - 1]
       for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            globalMaxSum = Math.max(globalMaxSum, maxSum);
            if (i > 0 && i < n - 1) {
                minSum = Math.min(minSum + nums[i], nums[i]);
                globalMinSum = Math.min(minSum, globalMinSum);
            }
       }

       globalMaxSum = Math.max(globalMaxSum, totalSum - globalMinSum);

       return globalMaxSum;
    }
}
