package solutions;

import java.util.PriorityQueue;

/**
 * 2208. Minimum Operations to Halve Array Sum
 */

public class S2208 {
    public int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for (int num : nums) {
            sum += num;
            maxHeap.offer((double) num);
        }

        double half = sum / 2.0;
        int res = 0;
        while (half > 0) {
            double num = maxHeap.poll() / 2.0;
            half -= num;
            maxHeap.offer(num);
            res++;
        }

        return res;
    }
}