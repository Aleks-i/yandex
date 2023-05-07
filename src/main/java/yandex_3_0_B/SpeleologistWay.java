package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpeleologistWay {
    private static int countStepForExit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int xStart = 0, yStart = 0, zStart = 0;

        int[][][] graph = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            reader.readLine();
            for (int j = 0; j < n; j++) {
                char[] str = reader.readLine().toCharArray();
                for (int k = 0; k < n; k++) {
                    if (str[k] == '#') {
                        graph[i][j][k] = -2;
                    } else if (i == 0 && str[k] == '.') {
                        graph[i][j][k] = -3;
                    } else if (str[k] == 'S') {
                        xStart = i;
                        yStart = j;
                        zStart = k;
                    }
                }
            }
        }

        LinkedList<Vertex> queue = new LinkedList<>();
        Vertex vertex = new Vertex(xStart, yStart, zStart);
//        printMatrix(graph, n);
        fillGraph(queue, graph, vertex);
//        printMatrix(graph, n);
        System.out.println(countStepForExit++);
    }

    private static void fillGraph(LinkedList<Vertex> queue, int[][][] cave, Vertex vertex) {
        queue.addFirst(vertex);
        while (!queue.isEmpty()) {
            vertex = queue.getLast();
            List<Vertex> neighbours = getNeighbours(cave, vertex);

            neighbours.forEach(queue::addFirst);
            queue.pollLast();
        }
    }

    private static List<Vertex> getNeighbours(int[][][] cave, Vertex vertex) {
        int[] steps = new int[]{0, 0, 1, 0, 0, -1, 0, 1, 0, 0, -1, 0, 1, 0, 0, -1, 0, 0};
        List<Vertex> vertexList = new ArrayList<>();
        for (int i = 0; i < steps.length; i++) {
            Vertex v;
            int idxX = steps[i] + vertex.x;
            int idxY = steps[++i] + vertex.y;
            int idxZ = steps[++i] + vertex.z;
            int countStep;
            try {
                countStep = cave[idxX][idxY][idxZ];
                if (countStep == 0) {
                    cave[idxX][idxY][idxZ] = cave[vertex.x][vertex.y][vertex.z] + 1;
                    v = new Vertex(idxX, idxY, idxZ);
                    vertexList.add(v);
                }
                if (countStep == -3 && countStepForExit == 0) {
                    countStepForExit = cave[vertex.x][vertex.y][vertex.z] + 1;
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }
        return vertexList;

    }

    private static void printMatrix(int[][][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    System.out.printf("%4d", matrix[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static class Vertex {
        int x;
        int y;
        int z;

        public Vertex(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
