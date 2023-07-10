package solutions;

import java.util.Arrays;

/**
 * 2300. Successful Pairs of Spells and Potions
 */

public class S2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            long target = success / spells[i] + (success % spells[i] == 0 ? 0 : 1);
            res[i] = getNumOfSuccessfulPotion(potions, target);
        }

        return res;
    }

    public int getNumOfSuccessfulPotion(int[] potions, long target) {
        int n = potions.length, left = 0, right = n - 1;
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] >= target) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return pos == -1 ? 0 : n - pos;
    }
}
