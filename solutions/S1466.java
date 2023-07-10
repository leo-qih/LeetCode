package solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 */

public class S1466 {
    public int minReorder(int n, int[][] connections) {
        List<Node>[] graph = new ArrayList[n];
        for (int i = 0; i < n - 1; i++) {
            int a = connections[i][0], b = connections[i][1];
            if (graph[a] == null) graph[a] = new ArrayList<>();
            graph[a].add(new Node(b, 1));
            if (graph[b] == null) graph[b] = new ArrayList<>();
            graph[b].add(new Node(a, 0));
        }

        int cnt = 0;
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int city = queue.removeFirst();
            for (Node p : graph[city]) {
                if (!visited[p.idx]) {
                    if (p.flag == 1) cnt++;
                    visited[p.idx] = true;
                    queue.addLast(p.idx);
                }
            }
        }

        return cnt;
    }

    class Node {
        int idx;
        int flag; // 1 means the edge has the same direction with the original connection, 0 means the edge has opposite direction

        public Node(int idx, int flag) {
            this.idx = idx;
            this.flag = flag;
        }
    }
}
