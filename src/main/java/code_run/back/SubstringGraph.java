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

        Map<String, Set<Graph>> graphsMap = new HashMap<>();

        chars.forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    private static class Graph {
        Map<String, Map<String, Node>> adjList = new HashMap<>();

        public void add(String src, String dest) {
            Node nodeDest = new Node(dest, 1);
            Map<String, Node> startNodeMap = new HashMap<>();
            startNodeMap.put(dest, nodeDest);
//            adjList.merge(src, startNodeMap, (o, n) -> {
//                o.merge()
//            });
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
