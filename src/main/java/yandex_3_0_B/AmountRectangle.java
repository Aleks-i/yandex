package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmountRectangle {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int k = Integer.parseInt(str[2]);

        int[][] psa = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    psa[i][j] = Integer.parseInt(line[j]);
                } else if (i == 0) {
                    psa[i][j] = psa[i][j - 1] + Integer.parseInt(line[j]);
                } else if (j == 0) {
                    psa[i][j] = psa[i - 1][j] + Integer.parseInt(line[j]);
                } else {
                    psa[i][j] = psa[i - 1][j] + psa[i][j - 1] + Integer.parseInt(line[j]) - psa[i - 1][j - 1];
                }
            }
        }
        
        for (int i = 0; i < k; i++) {
            String[] lineK = reader.readLine().split(" ");
            int result = computeMatrix(psa, Integer.parseInt(lineK[0]) - 1, Integer.parseInt(lineK[1]) - 1,
                    Integer.parseInt(lineK[2]) - 1, Integer.parseInt(lineK[3]) - 1);
            System.out.println(result);
        }
//        printMatrix(psa);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%-3d", anInt);
            }
            System.out.println();
        }
    }

    private static int computeMatrix(int[][] psa, int x1, int y1, int x2, int y2) {
        int result = psa[x2][y2];
        if (x1 == 0 && y1 == 0) {
            return result;
        } else if (x1 == 0) {
            return result - computeMatrix(psa, 0, 0, x2, y1 - 1);
        } else if (y1 == 0) {
            return result - computeMatrix(psa,0, 0, x1 - 1, y2);
        } else {
            return result - computeMatrix(psa, 0, 0, x1 - 1, y2) -
                    computeMatrix(psa, 0, 0, x2, y1 - 1) +
                    computeMatrix(psa, 0, 0, x1 - 1, y1 - 1);
        }
    }
}
