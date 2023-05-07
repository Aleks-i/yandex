package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CheapWayMaxWithCertificate {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        Integer[][] dp = new Integer[n + 1][m + 1];
        String[][] prev = new String[n + 1][m + 1];
        String[] line = new String[m];
        for (int i = 0; i <= n; i++) {
            if (i != 0) {
                line = reader.readLine().split(" ");
            }
            for (int j = 0; j <= m; j++) {
                int dpITop;
                int dpILeft;
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (i == 1 && j == 1) {
                    dp[i][j] = Integer.parseInt(line[j - 1]);
                    prev[i][j] = "0";
                }else if ((dpITop = dp[i - 1][j]) >= (dpILeft = dp[i][j - 1])) {
                    dp[i][j] = dpITop + Integer.parseInt(line[j - 1]);
                    prev[i][j] = "D";
                } else {
                    dp[i][j] = dpILeft + Integer.parseInt(line[j - 1]);
                    prev[i][j] = "R";
                }
            }
        }

        String[] way = new String[n + m - 2];
        Arrays.fill(way, "");
        int iPrev = 0;
        int jPrev = 0;
        String direction = "";
        for (int i = way.length - 1; i >= 0; i--) {
            if (i == way.length - 1) {
                iPrev = dp.length - 1;
                jPrev = dp[0].length - 1;
                direction = prev[iPrev][jPrev];
                way[i] = direction;
            } else if ("D".equals(direction)) {
                iPrev--;
                direction = prev[iPrev][jPrev];
                way[i] = direction;
            } else {
                jPrev--;
                direction = prev[iPrev][jPrev];
                way[i] = direction;
            }
        }

        System.out.println(dp[dp.length - 1][dp[0].length - 1]);

        for (String st : way) {
            System.out.print(st + " ");
        }
//        printMatrix(dp);
//        printMatrix(prev);
    }

    private static <T> void printMatrix(T[][] matrix) {
        for (T[] ints : matrix) {
            for (T anInt : ints) {
                if (matrix instanceof Integer[][]) {
                    System.out.printf("%-4d", anInt);
                } else {
                    System.out.printf("%-4s", anInt);
                }
            }
            System.out.println();
        }
    }
}
