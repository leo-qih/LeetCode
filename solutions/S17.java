package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 */

public class S17 {
    private static final String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        dfs(digits.toCharArray(), 0, new StringBuilder(), res);

        return res;
    }

    public void dfs(char[] digits, int idx, StringBuilder comb, List<String> res) {
        if (idx == digits.length) {
            res.add(comb.toString());
            return;
        }

        String letters = map[digits[idx] - '0'];
        for (int i = 0; i < letters.length(); i++) {
            comb.append(letters.charAt(i));
            dfs(digits, idx + 1, comb, res);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}
