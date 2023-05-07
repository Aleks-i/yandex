package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveHorse {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        long startTime = System.nanoTime();
        int[][] dp = new int[n][m];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++){
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int countWayPrevForStep1 = (i - 1 >= 0 && j - 2 >= 0) ?  dp[i - 1][j - 2] : 0;
                    int countWayPrevForStep2 = (i - 2 >= 0 && j - 1 >= 0) ?  dp[i - 2][j - 1] : 0;
                    dp[i][j] = countWayPrevForStep1 + countWayPrevForStep2;
                }
            }
        }
        System.out.println(dp[n - 1][m - 1]);
//        printMatrix(dp);
        long endTime = System.nanoTime();
//        System.out.println(TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS));
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
