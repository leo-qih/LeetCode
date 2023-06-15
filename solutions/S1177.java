package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1177. Can Make Palindrome from Substring
 */
public class S1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        // int n = s.length();
        // int[][] prefixCount = new int[n + 1][26];
        // for (int i = 1; i <= n; i++) {
        //     prefixCount[i] = prefixCount[i - 1].clone();
        //     prefixCount[i][s.charAt(i - 1) - 'a']++;
        // }
        
        // List<Boolean> res = new ArrayList<>(queries.length);
        // for (int[] query : queries) {
        //     int l = query[0], r= query[1], k = query[2];
        //     int oddCnt = 0;
        //     for (int i = 0; i < 26; i++) {
        //         oddCnt += (prefixCount[r + 1][i] - prefixCount[l][i]) % 2;
        //     }

        //     res.add(oddCnt / 2 <= k);
        // }

        // return res;

        int n = s.length();
        int[] prefixCount = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int bitMask = 1 << (s.charAt(i - 1) - 'a');
            prefixCount[i] = prefixCount[i - 1] ^ bitMask;
        }
        
        List<Boolean> res = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            int l = query[0], r= query[1], k = query[2];
            int oddCnt = Integer.bitCount(prefixCount[r + 1] ^ prefixCount[l]);
            res.add(oddCnt / 2 <= k);
        }

        return res;
    }
}
