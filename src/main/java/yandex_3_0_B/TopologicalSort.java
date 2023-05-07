package yandex_3_0_B;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TopologicalSort {

//    public static void main(String[] args) throws IOException {
////        long startTime = System.nanoTime();
////        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        List<String> strings = Files.readAllLines(Path.of("input.txt"));
//        int[] str = parsePair(strings.get(0).split(" "));
//        int n = str[0];
//        int m = str[1];
//
//        List<List<Integer>> graph = new ArrayList<>(n + 1);
//        for (int i = 0; i < n + 1; i++) {
//            graph.add(i, new ArrayList<>());
//        }
//
//        for (int i = 0; i <= m; i++) {
//            if (i != 0) {
//                int[] VE = parsePair(strings.get(i).split(" "));
//                graph.get(VE[0]).add(VE[1]);
//            }
//        }
//
////        printGraphs(graph);
//
//        List<Integer> tSort = new ArrayList<>();
//        int[] visited = new int[n + 1];
//        Stack<Integer> stack = new Stack<>();
//        boolean isCycle = false;
//        for (int i = 1; i < graph.size(); i++) {
//            if (visited[i] == 0) {
//                isCycle = dfs(i, 0, visited, graph, stack);
//                if (isCycle) {
//                    break;
//                }
//            }
//        }
//
//        if (isCycle) {
//            System.out.println(-1);
//        } else if (stack.size() == 1) {
//            System.out.println(-1);
//        } else {
//            while (!stack.isEmpty()) {
//                tSort.add(stack.pop());
//            }
//            tSort.forEach(v -> System.out.print(v + " "));
//        }
////        System.out.println();
////        long endTime = System.nanoTime();
////        System.out.println(TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS));
//    }
//
//    private static boolean dfs(int v, int root, int[] visited, List<List<Integer>> graph, Stack<Integer> stack) {
//        visited[v] = 1;
//
//        for (Integer vert : graph.get(v)) {
//            if (visited[vert] == 0 && vert != root && dfs(vert, v, visited, graph, stack)) {
//                return true;
//            } else if (visited[vert] == 1 && vert != root) {
//                return true;
//            }
//        }
//        stack.push(v);
//        visited[v] = 2;
//        return false;
//    }
//
//    private static int[] parsePair(String[] str) {
//        return new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])};
//    }
//
//    private static void printGraphs(List<List<Integer>> graphs) {
//        IntStream.range(0, graphs.size())
//                .forEach(index -> {
//                    if (index != 0) {
//                        System.out.print(index + ": ");
//                        graphs.get(index).forEach(v -> {
//                            System.out.print(v + " ");
//                        });
//                        System.out.println();
//                    }
//                });
//    }
}
