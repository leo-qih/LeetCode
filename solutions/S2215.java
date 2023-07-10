package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 2215. Find the Difference of Two Arrays
 */

public class S2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        res.add(new ArrayList<>());
        for (Integer num : set1) {
            if (!set2.contains(num)) {
                res.get(0).add(num);
            }
        }
        res.add(new ArrayList<>());
        for (Integer num : set2) {
            if (!set1.contains(num)) {
                res.get(1).add(num);
            }
        }

        return res;
    }
}
