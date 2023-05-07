package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DepthSearch {
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

        Set<Integer> depthFirstTraversal = getDepthFirstTraversal(graphs);

        System.out.println(depthFirstTraversal.size());
        depthFirstTraversal.forEach(v -> System.out.print(v + " "));
    }

    private static Set<Integer> getDepthFirstTraversal(List<Set<Integer>> graphs) {
        Set<Integer> visited = new TreeSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited.contains(vertex)) {
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
