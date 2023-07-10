package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 */

public class S216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, n, 1);

        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> comb, int k, int remain, int start) {
        if (remain < 0) return;
        if (comb.size() == k) {
            if (remain == 0) res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i <= 9; i++) {
            comb.add(i);
            dfs(res, comb, k, remain - i, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
