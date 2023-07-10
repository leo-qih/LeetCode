package solutions;

/**
 * 162. Find Peak Element
 */

public class S162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length, left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
