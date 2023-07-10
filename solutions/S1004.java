package solutions;

/**
 * 1004. Max Consecutive Ones III
 */

public class S1004 {
    public int longestOnes(int[] nums, int k) {
        int maxNumofOne = 0, numOfOne = 0, numOfZero = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 1) numOfOne++;
            else numOfZero++;

            while (l <= r && numOfZero > k) {
                if (nums[l] == 1) numOfOne--;
                else numOfZero--;
                l++;
            }
            maxNumofOne = Math.max(maxNumofOne, numOfOne + numOfZero);
        }

        return maxNumofOne;
    }
}
