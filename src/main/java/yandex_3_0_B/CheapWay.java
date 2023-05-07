package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheapWay {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[][] dp = new int[n + 1][m + 1];
        String[] line = new String[m];
        for (int i = 0; i <= n; i++) {
            if (i != 0) {
                line = reader.readLine().split(" ");
            }
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else if (i == 1 && j == 1) {
                    dp[i][j] = Integer.parseInt(line[j - 1]);
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + Integer.parseInt(line[j - 1]);
                }
            }
        }

        System.out.println(dp[dp.length - 1][dp[0].length - 1]);

//        printMatrix(dp);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%-4d", anInt);
            }
            System.out.println();
        }
    }
}
