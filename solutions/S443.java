package solutions;

/**
 * 443. String Compression
 */

public class S443 {
    public int compress(char[] chars) {
        int n = chars.length;
        int left = 0, idx = 0;
        for (int right = 0; right <= n; right++) {
            if (right == n || chars[right] != chars[left]) {
                chars[idx++] = chars[left];
                if (right - left > 1) {
                    String numStr = String.valueOf(right - left);
                    for (int i = 0; i < numStr.length(); i++) {
                        chars[idx++] = numStr.charAt(i);
                    }
                }
                left = right;
                
            }
        }

        return idx;
    }
}
