package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 399. Evaluate Division
 */

public class S399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            graph.putIfAbsent(equation.get(0), new HashMap<>());
            graph.get(equation.get(0)).put(equation.get(1), values[i]);
            graph.putIfAbsent(equation.get(1), new HashMap<>());
            graph.get(equation.get(1)).put(equation.get(0), 1 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            HashSet<String> visited = new HashSet<>();
            res[i] = calc(graph, queries.get(i).get(0), queries.get(i).get(1), visited);
        }

        return res;
    }

    double calc(HashMap<String, HashMap<String, Double>> graph, String source, String dest, HashSet<String> visited) {
        if (!graph.containsKey(source) || !graph.containsKey(dest)) {
            return -1;
        }
        if (source.equals(dest)) {
            return 1;
        }
    
        
        for (String key: graph.get(source).keySet()) {
            if (key.equals(dest)) {
                return graph.get(source).get(dest);
            }
            if (!visited.contains(key)) {
                visited.add(key);
                double res = calc(graph, key, dest, visited);
                if (res != -1) {
                    return res * graph.get(source).get(key);
                }
            }
        }

        return -1;
    }
}
