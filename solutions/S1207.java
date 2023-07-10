package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. Unique Number of Occurrences
 */

public class S1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : arr) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (Integer val : freqs.values()) {
            if (set.contains(val)) {
                return false;
            }
            set.add(val);
        }

        return true;
    }
}
