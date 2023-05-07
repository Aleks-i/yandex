package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Fleas {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int s = Integer.parseInt(str[2]) - 1;
        int t = Integer.parseInt(str[3]) - 1;
        int q = Integer.parseInt(str[4]);

        List<Flea> fleaList = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            str = reader.readLine().split(" ");
            fleaList.add(new Flea(Integer.parseInt(str[0]) - 1, Integer.parseInt(str[1]) - 1));
        }

        int[][] board = new int[n][m];
        LinkedList<Vertex> queue = new LinkedList<>();
        fillGraph(queue, board, s, t);
//        fleaList.forEach(System.out::println);

        boolean isTogether = true;
        int stepToFeeder = 0;
        for (Flea f : fleaList) {
            int step = board[f.x][f.y];
            if (step == 0 && f.x != s && f.y != t ) {
                isTogether = false;
                break;
            } else if (f.x == s && f.y == t){
                stepToFeeder += 0;
            } else {
                stepToFeeder += step;
            }
        }
        if (!isTogether) {
            System.out.println(-1);
        } else {
            System.out.println(stepToFeeder);
        }
//        printMatrix(board);
    }

    private static void fillGraph(LinkedList<Vertex> queue, int[][] board, int xTarget, int yTarget) {
        queue.addFirst(new Vertex(xTarget, yTarget, 0));
        while (!queue.isEmpty()) {
            Vertex vertex = queue.getLast();
            List<Vertex> vertexList = checkValidVertex(board, vertex);

            for (Vertex vChild : vertexList) {
                queue.addFirst(vChild);
            }
            queue.pollLast();
        }
    }

    private static List<Vertex> checkValidVertex(int[][] board, Vertex vertex) {
        int[] steps = new int[]{-2, 1, -1, 2, 2, 1, 1, 2, -2, -1, -1, -2, 2, -1, 1, -2};
        List<Vertex> vertexList = new ArrayList<>();
//        board[vertex.x][vertex.y] = 5;
        for (int i = 0; i < steps.length; i++) {
            Vertex v;
            int idxX = steps[i] + vertex.x;
            int idxY = steps[++i] + vertex.y;
            int countStep;
            try {
                countStep = board[idxX][idxY];
                if (countStep < 1) {
                    board[idxX][idxY] = countStep = vertex.stepForTarget + 1;
                    v = new Vertex(idxX, idxY, countStep);
                    vertexList.add(v);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                countStep = 0;
            }
        }
        return vertexList;
    }

    private static void printMatrix(int[][] board) {
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    private static class Vertex {
        int x;
        int y;
        int stepForTarget;

        public Vertex(int x, int y, int stepForTarget) {
            this.x = x;
            this.y = y;
            this.stepForTarget = stepForTarget;
        }

        @Override
        public String toString() {
            return "Flea{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static class Flea {
        int x;
        int y;

        public Flea(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Flea{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
