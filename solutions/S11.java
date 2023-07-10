package solutions;

/**
 * 11. Container With Most Water
 */

public class S11 {
    public int maxArea(int[] height) {
        // i, j, min(height[i], height[j]) * (j - i + 1)
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(area, maxArea);
            if (height[i] < height[j]) i++;
            else j--;
        }

        return maxArea;
    }
}
