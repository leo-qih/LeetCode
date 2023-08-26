package solutions;

import java.util.Arrays;

/**
 * 833. Find And Replace in String
 */

public class S833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length, sLen = s.length();
        Integer[] indicesIdx = new Integer[n];
        for (int i = 0; i < n; i++) indicesIdx[i] =i;
        Arrays.sort(indicesIdx, (a, b) -> indices[a] - indices[b]);

        StringBuilder res = new StringBuilder();
        int curIdx = 0;
        for (int i = 0; i < n; i++) {
            int start = indices[indicesIdx[i]];
            res.append(s.substring(curIdx, start));
            curIdx = start;

            if (s.startsWith(sources[indicesIdx[i]], start)) {
                res.append(targets[indicesIdx[i]]);
                curIdx += sources[indicesIdx[i]].length();
            }
        }
        res.append(s.substring(curIdx, sLen));

        return res.toString();
    }
}
