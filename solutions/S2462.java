package solutions;

import java.util.PriorityQueue;

/**
 * 2462. Total Cost to Hire K Workers
 */

public class S2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        long totalCost = 0L;
        PriorityQueue<Integer> firstWorkers = new PriorityQueue<>();
        PriorityQueue<Integer> lastWorkers = new PriorityQueue<>();

        int n = costs.length, idxFirst = 0, idxLast = n - 1;
        for (; idxFirst < candidates && idxFirst < n; idxFirst++) {
            firstWorkers.offer(costs[idxFirst]);
        }
        for (; idxLast > n - 1 - candidates && idxLast >= idxFirst; idxLast--) {
            lastWorkers.offer(costs[idxLast]);
        }

        for (int i = 0; i < k; i++) {
            if (firstWorkers.isEmpty()) {
                totalCost += lastWorkers.poll();
                if (idxLast >= idxFirst) {
                    lastWorkers.offer(costs[idxLast]);
                    idxLast--;
                }
            } else if (lastWorkers.isEmpty()) {
                totalCost += firstWorkers.poll();
                if (idxFirst <= idxLast) {
                    firstWorkers.offer(costs[idxFirst]);
                    idxFirst++;
                }
            } else {
                if (firstWorkers.peek() <= lastWorkers.peek()) {
                    totalCost += firstWorkers.poll();
                    if (idxFirst <= idxLast) {
                        firstWorkers.offer(costs[idxFirst]);
                        idxFirst++;
                    }
                } else {
                    totalCost += lastWorkers.poll();
                    if (idxLast >= idxFirst) {
                        lastWorkers.offer(costs[idxLast]);
                        idxLast--;
                    }
                }
            }
        }

        return totalCost;
    }
}
