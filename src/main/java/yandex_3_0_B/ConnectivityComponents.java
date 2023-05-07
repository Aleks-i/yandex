package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConnectivityComponents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] str = parsePair(reader.readLine().split(" "));
        int n = str[0];
        int m = str[1];

        List<Set<Integer>> graphs = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            graphs.add(i, new TreeSet<>());
        }

        for (int i = 0; i < m; i++) {
            int[] VE = parsePair(reader.readLine().split(" "));
            graphs.get(VE[0]).add(VE[1]);
            graphs.get(VE[1]).add(VE[0]);
        }

        boolean[] visited = new boolean[n + 1];
        Map<Integer, Set<Integer>> connectivityComponents = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                Set<Integer> depthFirstTraversal = getDepthFirstTraversal(graphs, i, visited);
                connectivityComponents.put(i, depthFirstTraversal);
            }
        }

        System.out.println(connectivityComponents.size());
        connectivityComponents.forEach((k, v) -> {
            System.out.println(v.size());
            v.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
    }

    private static Set<Integer> getDepthFirstTraversal(List<Set<Integer>> graphs, int root, boolean[] visitedEarly) {
        Set<Integer> visited = new TreeSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visitedEarly[vertex] = true;
                visited.add(vertex);
                for (Integer v : graphs.get(vertex)) {
                    stack.push(v);
                }
            }
        }
        return visited;
    }

    private static int[] parsePair(String[] str) {
        return new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])};
    }
}
