package solutions;

/**
 * 1493. Longest Subarray of 1's After Deleting One Element
 */

public class S1493 {
    public int longestSubarray(int[] nums) {
        int maxLen = 0, cntZero = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 0) cntZero++;
            while (l <= r && cntZero > 1) {
                if (nums[l] == 0) cntZero--;
                l++;
            }
            if (cntZero <= 1) maxLen = Math.max(maxLen, r - l);
        }

        return maxLen;
    }
}
