package yandex_3_0;

import yandex_3_0_B.SpeleologistWay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TsarLeonidTractor {
//    private static int countStepForExit;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String[] str = reader.readLine().split(" ");
//        int h = Integer.parseInt(str[0]);
//        int w = Integer.parseInt(str[1]);
//
////        int xStart = 0, yStart = 0, zStart = 0;
//
//        int[][] dp = new int[h][w];
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                char[] str1 = reader.readLine().toCharArray();
//                if (str1[j] == 'X') {
//                    dp[i][j] = -1;
//                }
//            }
//        }
//        str = reader.readLine().split(" ");
//        int xStart = Integer.parseInt(str[0]);
//        int yStart = Integer.parseInt(str[1]);
//        str = reader.readLine().split(" ");
//        int xEnd = Integer.parseInt(str[0]);
//        int yEnd = Integer.parseInt(str[1]);
//
//        LinkedList<Vertex> queue = new LinkedList<>();
//        Vertex vertex = new Vertex(xStart, yStart);
////        printMatrix(graph, n);
//        fillGraph(queue, dp, vertex);
////        printMatrix(graph, n);
//        System.out.println(countStepForExit++);
//    }
//
//    private static void fillGraph(LinkedList<Vertex> queue, int[][][] cave, Vertex vertex) {
//        queue.addFirst(vertex);
//        while (!queue.isEmpty()) {
//            vertex = queue.getLast();
//            List<Vertex> neighbours = getNeighbours(cave, vertex);
//
//            neighbours.forEach(queue::addFirst);
//            queue.pollLast();
//        }
//    }
//
//    private static List<Vertex> getNeighbours(int[][][] cave, SpeleologistWay.Vertex vertex) {
//        int[] steps = new int[]{0, 0, 1, 0, 0, -1, 0, 1, 0, 0, -1, 0, 1, 0, 0, -1, 0, 0};
//        List<Vertex> vertexList = new ArrayList<>();
//        for (int i = 0; i < steps.length; i++) {
//            Vertex v;
//            int idxX = steps[i] + vertex.x;
//            int idxY = steps[++i] + vertex.y;
//            int idxZ = steps[++i] + vertex.z;
//            int countStep;
//            try {
//                countStep = cave[idxX][idxY][idxZ];
//                if (countStep == 0) {
//                    cave[idxX][idxY][idxZ] = cave[vertex.x][vertex.y][vertex.z] + 1;
//                    v = new SpeleologistWay.Vertex(idxX, idxY, idxZ);
//                    vertexList.add(v);
//                }
//                if (countStep == -3 && countStepForExit == 0) {
//                    countStepForExit = cave[vertex.x][vertex.y][vertex.z] + 1;
//                }
//            } catch (ArrayIndexOutOfBoundsException ignored) {
//            }
//        }
//        return vertexList;
//
//    }
//
//    private static void printMatrix(int[][][] matrix, int size) {
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                for (int k = 0; k < size; k++) {
//                    System.out.printf("%4d", matrix[i][j][k]);
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
//    }
//
//    private static class Vertex {
//        int x;
//        int y;
//        int z;
//
//        public Vertex(int x, int y, int z) {
//            this.x = x;
//            this.y = y;
//            this.z = z;
//        }
//    }
}
