package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Metro {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        Map<Integer, List<Integer>> branches = new HashMap<>();
        Map<Integer, List<Integer>> stations = new HashMap<>();
        IntStream.range(1, n + 1).forEach(i -> stations.put(i, new ArrayList<>()));
        IntStream.range(1, m + 1).forEach(i -> branches.put(i, new ArrayList<>()));
        for (int i = 1; i <= m; i++) {
            String[] str = reader.readLine().split(" ");
            int countStation = Integer.parseInt(str[0]);
            for (int j = 1; j <= countStation; j++) {
                branches.get(i).add(Integer.parseInt(str[j]));
                stations.get(Integer.parseInt(str[j])).add(i);
            }
        }
        String[] str = reader.readLine().split(" ");
        int stationStart = Integer.parseInt(str[0]);
        int stationEnd = Integer.parseInt(str[1]);

        int i = fillCountTransfer(branches, stations, stationStart, stationEnd);
        System.out.println(i);
//        printMetroGraph(stations);
//        System.out.println();
//        printMetroGraph(branches);
    }

    private static int fillCountTransfer(Map<Integer, List<Integer>> branches, Map<Integer, List<Integer>> stations,
                                         int stationStart, int stationEnd) {
        Map<Integer, Integer> countTransfers = new HashMap<>();
        IntStream.range(1, stations.size() + 1).forEach(s -> countTransfers.put(s, -1));
        int counter = 0;
        boolean[] branchVisited = new boolean[branches.size() + 1];
        Set<Integer> branchesForStantion = new HashSet<>(stations.get(stationStart));
        Deque<Set<Integer>> branchDeque = new ArrayDeque<>();
        branchDeque.addFirst(branchesForStantion);
        while (!branchDeque.isEmpty()) {
            Set<Integer> branchesStantion = branchDeque.getLast();
            int finalCounter = counter;
            Set<Integer> bs = new HashSet<>();
            branchesStantion.forEach(b -> {
                if (!branchVisited[b]) {
                    branchVisited[b] = true;
                    branches.get(b).forEach(s -> {
                        if (countTransfers.get(s) == -1) {
                            countTransfers.put(s, finalCounter);
                        }
                        stations.get(s).forEach(br -> {
                            if (!branchVisited[br] && !branchesStantion.contains(br)) {
                                bs.add(br);
                            }
                        });
                    });
                }
                branchVisited[b] = true;
            });
            if (!bs.isEmpty()) {
                branchDeque.addFirst(bs);
            }
            counter++;
            branchDeque.pollLast();
        }
//        countTransfers.forEach((k ,v) -> System.out.println(k + ": " + v));
        return countTransfers.get(stationEnd);
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

    private static void printMetroGraph(Map<Integer, List<Integer>> metroGraph) {
        System.out.println();
        IntStream.range(0, metroGraph.size() + 1)
                .forEach(index -> {
                    if (index != 0) {
                        System.out.print(index + ": ");
                        metroGraph.get(index).forEach(v -> {
                            System.out.print(v + " ");
                        });
                        System.out.println();
                    }
                });
    }
}
