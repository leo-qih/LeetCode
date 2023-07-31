package solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 2050. Parallel Courses III
 */

public class S2050 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        int[] inDegree = new int[n];
        for (int[] relation : relations) {
            int from = relation[0] - 1, to = relation[1] - 1;
            graph[from].add(to);
            inDegree[to]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        int minTime = 0;
        int[] dp = new int[n]; // dp[i] = time[i] + max(dp[j]), j is prev course of i
        while (!queue.isEmpty()) {
            int node = queue.poll();
            dp[node] += time[node];
            minTime = Math.max(minTime, dp[node]);
            for (int neighbor : graph[node]) {
                dp[neighbor] = Math.max(dp[neighbor], dp[node]); // max time required for prev courses of neighbor
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        return minTime;
    }
}