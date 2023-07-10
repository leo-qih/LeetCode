package solutions;

/**
 * 724. Find Pivot Index
 */
public class S724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] rightSum = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }
        int leftSum = 0, idx = 0;
        while (idx < n) {
            if (leftSum == rightSum[idx]) break;
            leftSum += nums[idx];
            idx++;
        }

        return idx < n ? idx : -1;
    }
}
