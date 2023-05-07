package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ShortestWay {

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

        String[] str = reader.readLine().split(" ");
        int vStart = Integer.parseInt(str[0]);
        int vTarget = Integer.parseInt(str[1]);
        LinkedList<Integer> queue = new LinkedList<>();
        int[] way = new int[graph.size()];
        findShortestWay(graph, vStart, queue, way);
//        printGraphs(graph);
        if (vStart == vTarget) {
            System.out.println(0);
        } else if (way[vTarget] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(way[vTarget]);
        }
    }

    private static void findShortestWay(List<List<Integer>> graph, int vStart, LinkedList<Integer> queue, int[] way) {
        queue.addFirst(vStart);
        while (!queue.isEmpty()) {
            int vRoot = queue.getLast();
            for (Integer vChild : graph.get(vRoot)) {
                if (way[vChild] == 0 && vChild != vStart) {
                    queue.addFirst(vChild);
                    way[vChild] = way[vRoot] + 1;
                }
            }
            queue.pollLast();
        }
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
