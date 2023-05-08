package code_run.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class SubstringGraph {
    public static void main(String[] args) throws IOException {
        List<char[]> chars = Files.readAllLines(Paths.get("input.txt")).stream()
                .skip(1)
                .map(String::toCharArray)
                .collect(Collectors.toList());

        sol1(chars);
    }

    private static TreeMap<String, TreeMap<String, Node>> sol1(List<char[]> chars) {
        Graph graph = new Graph();

        chars.forEach(chars1 -> {
            for (int i = 0; i < chars1.length - 3; i++) {
                StringBuilder sbSrc = new StringBuilder();
                StringBuilder sbDest = new StringBuilder();

                for (int j = i; j < i + 3; j++) {
                    sbSrc.append(chars1[j]);
                    sbDest.append(chars1[j + 1]);
                }
                graph.addVertex(sbSrc.toString(), sbDest.toString());
                graph.addNode(sbSrc.toString(), sbDest.toString());
            }
        });

        System.out.println(graph.adjList.size());
        System.out.println(graph.adjList.values().stream()
                .mapToInt(Map::size).sum());

        graph.adjList.forEach((k, v) -> {
            v.forEach((k1, v1) -> {
                System.out.println(k + " " + k1 + " " + v1.weight);
            });
        });
        return graph.adjList;
    }

    //add implementation of saving all vertices
    private static void sol2(List<char[]> chars) {
        List<Pair> pairs = new ArrayList<>();
        for (char[] aChar : chars) {
            for (int j = 0; j < aChar.length - 3; j++) {
                pairs.add(new Pair(String.valueOf(Arrays.copyOfRange(aChar, j, j + 3)),
                        String.valueOf(Arrays.copyOfRange(aChar, j + 1, j + 4))));
            }
        }
        Map<String, Map<String, Long>> fMap = pairs.stream()
                .collect(Collectors.groupingBy(Pair::getFirst,
                        Collectors.groupingBy(Pair::getSecond, Collectors.counting())));

        System.out.println(fMap.size());
        System.out.println(fMap.values().stream().mapToInt(Map::size).sum());

        fMap.forEach((k, v) -> v.forEach((k1, v1) -> {
            System.out.println(k + " " + k1 + " " + v1);
        }));
    }

    private static class Pair {
        String first;
        String second;

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getSecond() {
            return second;
        }

        public void setSecond(String second) {
            this.second = second;
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    private static class Graph {
        TreeMap<String, TreeMap<String, Node>> adjList = new TreeMap<>();

        public void addVertex(String src, String dest) {
            adjList.putIfAbsent(src, new TreeMap<>());
            adjList.putIfAbsent(dest, new TreeMap<>());
        }

        public void addNode(String src, String dest) {
            TreeMap<String, Node> nodes = adjList.get(src);
            nodes.merge(dest, new Node(dest, 1), (o, n) -> {
                o.weight++;
                return o;
            });
        }
    }

    private static class Node {
        String value;
        int weight;

        public Node(String value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public static class Test {
        public static char[] getSeqChar(int n) {
            Random rnd = new Random();
            char[] res = new char[n];
            for (int i = 0; i < n; i++) {
                char c = (char) ('a' + rnd.nextInt(26));
                res[i] = c;
            }
            return res;
        }
    }
}
