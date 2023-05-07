package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NOPWithAnswer {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] consistency1 = getConsistency(reader.readLine().split(" "));
        int m = Integer.parseInt(reader.readLine().trim());
        int[] consistency2 = getConsistency(reader.readLine().split(" "));

        int[][] dp = new int[n + 1][m + 1];
        int lastCoincidences = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (consistency1[i] != consistency2[j]) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                } else if (consistency1[i] == consistency2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > lastCoincidences) {
                        lastCoincidences++;
                    }
                }
            }
        }

        int startElemetn = dp[n][m];
        List<Integer> result = new ArrayList<>();
        int idxI = n;
        int idxJ = m;
        while (startElemetn != 0) {
            if (dp[idxI][idxJ - 1] == startElemetn) {
                idxJ--;
            } else if (dp[idxI - 1][idxJ] == startElemetn) {
                idxI--;
            } else {
                result.add(0, consistency1[idxI]);
                startElemetn--;
                idxI--;
                idxJ--;
            }
        }

        result.forEach(i -> System.out.print(i + " "));
        System.out.println();
//        printMatrix(dp);
    }

    private static int[] getConsistency(String[] str) {
        int[] result = new int[str.length + 1];
        for (int i = 1; i <= str.length; i++) {
            result[i] = Integer.parseInt(str[i - 1]);
        }
        return result;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%-4d", anInt);
            }
            System.out.println();
        }
    }
}
