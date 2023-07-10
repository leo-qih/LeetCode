package solutions;

import java.util.HashSet;
import java.util.List;

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 */

public class S1456 {
    public int maxVowels(String s, int k) {
        HashSet<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        int maxCnt = 0, cnt = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                cnt++;
            }
        }
        maxCnt = cnt;
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                cnt++;
            }
            if (vowels.contains(s.charAt(i - k))) {
                cnt--;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }

        return maxCnt;
    }
}
