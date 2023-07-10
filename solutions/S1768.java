package solutions;

/**
 * 1768. Merge Strings Alternately
 */

public class S1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int m = word1.length(), n = word2.length();
        for (int i = 0; i < m || i < n; i++) {
            if (i < m) sb.append(word1.charAt(i));
            if (i < n) sb.append(word2.charAt(i));
        }

        return sb.toString();
    }
}
