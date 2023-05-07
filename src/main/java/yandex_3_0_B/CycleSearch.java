package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.IntStream;

public class CycleSearch {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 1; j < i; j++) {
                int relations = Integer.parseInt(line[j - 1]);
                if (relations == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        List<Integer> cycleVertex = new ArrayList<>();
        int[] visited = new int[graph.size()];
        Stack<Integer> stack = new Stack<>();
        String resultMessage = "NO";
        for (int i = 0; i < graph.size(); i++) {
            stack = new Stack<>();
            boolean flag = dfs(i, 0, visited, graph, stack, cycleVertex);
            if (flag) {
                resultMessage = "YES";
                break;
            }
        }
        System.out.println(resultMessage);
        if (!cycleVertex.isEmpty()) {
            System.out.println(cycleVertex.size());
            cycleVertex.forEach(v -> System.out.print(v + " "));
        }
//        System.out.println();
//        printGraphs(graph);
    }

    static boolean dfs(int v, int root, int[] visited, List<List<Integer>> graph, Stack<Integer> stack, List<Integer> cycleVertex) {
        visited[v] = 1;
        stack.push(v);

        for (Integer vert : graph.get(v)) {
            if (visited[vert] == 0 && vert != root && dfs(vert, v, visited, graph, stack, cycleVertex)) {
                return true;
            } else if (visited[vert] == 1 && vert != root) {
                while (!Objects.equals(stack.peek(), vert)) {
                    cycleVertex.add(stack.pop());
                }
                cycleVertex.add(stack.pop());
                return true;
            }
        }

        visited[v] = 2;
        stack.pop();
        return false;
    }

    private static void printGraphs(List<List<Integer>> graphs) {
        System.out.println();
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
}
