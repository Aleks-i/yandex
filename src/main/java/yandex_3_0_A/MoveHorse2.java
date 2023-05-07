package yandex_3_0_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MoveHorse2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        long startTime = System.nanoTime();
        int[][] dp = new int[n][m];
//        int[] stepType1 = new int[]{-1, -2};
//        int[] stepType2 = new int[]{1, -2};
//        int[] stepType3 = new int[]{-2, -1};
//        int[] stepType4 = new int[]{-2, 1};
//        fillDP(dp,stepType1);
//        System.out.println("Step 1");
//        printMatrix(dp);
//        fillDP(dp,stepType2);
//        System.out.println("Step 2");
//        printMatrix(dp);
//        fillDP(dp,stepType3);
//        System.out.println("Step 3");
//        printMatrix(dp);
//        fillDP(dp,stepType4);
//        System.out.println("Step 4");
//        printMatrix(dp);

        int lehgthI;
        int lehgthJ;
        for (int k = 0; k <= Math.max(n - 1, m - 1); k++) {
            if (n > m) {
                lehgthI = k > n - 1 ? n - 1 : k - 1;
                lehgthJ = k > m - 1 ? m - 1 : k;
            } else {
                lehgthI = k > n - 1 ? n - 1 : k;
                lehgthJ = k > m - 1 ? m - 1 : k - 1;
            }
            int i = 0;
            int j = 0;
            for (; i <= lehgthI; i++) {
                if (k <= m - 1) {
                    step(dp, i, k);
                }
            }
            for (; j <= lehgthJ; j++) {
                if (k <= n - 1) {
                    step(dp, k, j);
                }
            }
        }
//
//        for (int k = 0; k < dp.length; k += 2) {
//            for (int j = 0; j < dp[0].length; j++) {
//                int i = k;
//                int idxLast = k + 2;
//                while (idxLast > dp.length - 1) {
//                    idxLast--;
//                }
//                for (; i <= idxLast; i++) {
//                    if (i == 0 && j == 0) {
//                        dp[i][j] = 1;
//                    } else {
//                        int countWayPrevForStep1 = (i - 1 >= 0 && j - 2 >= 0) ? dp[i - 1][j - 2] : 0;
//                        int countWayPrevForStep2 = (i + 1 < dp.length && j - 2 >= 0) ? dp[i + 1][j - 2] : 0;
//                        dp[i][j] += countWayPrevForStep1 + countWayPrevForStep2;
//
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < dp.length; i += 2) {
//            for (int j = 0; j < dp[0].length; j++) {
//                if (i == 0 && j == 0) {
//                    dp[i][j] = 1;
//                } else {
//                    int countWayPrevForStep3 = (i - 2 >= 0 && j - 1 >= 0) ? dp[i - 2][j - 1] : 0;
//                    int countWayPrevForStep4 = (i - 2 >= 0 && j + 1 < dp[0].length) ? dp[i - 2][j + 1] : 0;
//                    dp[i][j] += countWayPrevForStep3 + countWayPrevForStep4;
//
//                }
//            }
//        }
        PrintWriter consoleOutput = new PrintWriter(System.out);
        consoleOutput.println(dp[n - 1][m - 1]);
        long endTime = System.nanoTime();
//        consoleOutput.println(TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS));
        printMatrix(dp);
        consoleOutput.flush();
        consoleOutput.close();
    }

    private static void step(int[][] dp, int i, int j) {
        if (i == 0 && j == 0) {
            dp[i][j] = 1;
        } else {
            int countWayPrevForStep1 = (i - 1 >= 0 && j - 2 >= 0) ? dp[i - 1][j - 2] : 0;
            int countWayPrevForStep2 = (i + 1 < dp.length && j - 2 >= 0) ? dp[i + 1][j - 2] : 0;
            int countWayPrevForStep3 = (i - 2 >= 0 && j - 1 >= 0) ? dp[i - 2][j - 1] : 0;
            int countWayPrevForStep4 = (i - 2 >= 0 && j + 1 < dp[0].length) ? dp[i - 2][j + 1] : 0;
            dp[i][j] += countWayPrevForStep1 + countWayPrevForStep2 + countWayPrevForStep3 + countWayPrevForStep4;
        }
    }

//    private static void fillDP(int[][] dp, int[] steps) {
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                int k = i + steps[0];
//                int m = j + steps[1];
//                if (i == 0 && j == 0) {
//                    dp[i][j] = 1;
//                } else if (k >= 0 && k < dp.length && m >= 0 && m < dp[0].length) {
//                    dp[i][j] += dp[k][m];
//                }
//            }
//        }
//    }

    private static void printMatrix(int[][] matrix) {
        PrintWriter consoleOutput = new PrintWriter(System.out);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                consoleOutput.printf("%-6d", anInt);
            }
            consoleOutput.println();
            consoleOutput.println();
            consoleOutput.flush();
        }
    }
}
