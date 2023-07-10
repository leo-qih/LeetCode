package solutions;

import java.util.TreeSet;

/**
 * 2336. Smallest Number in Infinite Set
 */

public class S2336 {
    TreeSet<Integer> set;

    public S2336() {
        set = new TreeSet<>();
        for (int i = 1; i <= 1000; i++) {
            set.add(i);
        }
    }
    
    public int popSmallest() {
        return set.pollFirst();
    }
    
    public void addBack(int num) {
        if (!set.contains(num)) {
            set.add(num);
        }
    }
}
