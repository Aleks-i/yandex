package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Cheating {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] pair = parsePair(reader.readLine());
        int n = pair[0];
        int m = pair[1];

        List<Set<Integer>> graphs = new ArrayList<>(m + 1);
        for (int i = 0; i < n + 1; i++) {
            graphs.add(i, new TreeSet<>());
        }

        for (int i = 0; i < m; i++) {
            int[] VE = parsePair(reader.readLine());
            graphs.get(VE[0]).add(VE[1]);
            graphs.get(VE[1]).add(VE[0]);
        }

        boolean[] visited = new boolean[n + 1];
        String cheating = "YES";
        for (int i = 1; i < n + 1; i++) {
            if (!checkDicotyledonous(graphs, i, visited) || graphs.size() == 2) {
                cheating = "NO";
            }
        }
        System.out.println(cheating);
//        printGraphs(graphs);
    }

    private static boolean checkDicotyledonous(List<Set<Integer>> graphs, int root, boolean[] visitedEarly) {
        int[] color = new int[graphs.size()];
        Set<Integer> visited = new TreeSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        color[root] = 1;
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            int colorElement = color[vertex];
            if (!visited.contains(vertex)) {
                visitedEarly[vertex] = true;
                visited.add(vertex);
                for (Integer v : graphs.get(vertex)) {
                    if (colorElement == color[v]) {
                        return false;
                    }
                    color[v] = 3 - colorElement;
                    stack.push(v);
                }
            }
        }
        return true;
    }

    private static void printGraphs(List<Set<Integer>> graphs) {
        IntStream.range(0, graphs.size())
                .forEach(index -> {
                    if (index != 0) {
                        System.out.print(index + ": ");
                        graphs.get(index).forEach(v -> {
                            System.out.print(v + " ");
                        });
                        System.out.println();
                    }
                });
    }


    private static int[] parsePair(String str) {
        String[] p = str.split(" ");
        return new int[]{Integer.parseInt(p[0]), Integer.parseInt(p[1])};
    }
}
