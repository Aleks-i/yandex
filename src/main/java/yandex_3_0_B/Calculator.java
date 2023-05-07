package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] operationIdx = new int[n];
        int result = calculate(n, operationIdx);
        System.out.println(result);

        int[] resultOperation = new int[result + 1];
        resultOperation[resultOperation.length - 1] = n;
        int idxO = operationIdx.length - 1;
        int idxR = resultOperation.length - 2;
        while (idxR >= 0) {
            resultOperation[idxR] = operationIdx[idxO] + 1;
            idxR--;
            idxO = operationIdx[idxO];
        }

        for (int i = 0; i <= resultOperation.length - 1; i++) {
            System.out.print(resultOperation[i] + " ");
        }
    }

    private static int calculate(int n, int[] resultOperation) {
        int[] dp = new int[n];
        int i = 1;
        while (i <= n) {
            int resultForStep = Integer.MAX_VALUE;
            if (i == 1) {
                dp[i - 1] = 0;
                resultOperation[i - 1] = 1;
            } else {
                if (i % 2 == 0 && resultForStep >= dp[i / 2 - 1] + 1) {
                    resultForStep = dp[i / 2 - 1] + 1;
                    resultOperation[i - 1] = i / 2 - 1;
                }
                if (resultForStep >= dp[i - 2] + 1) {
                    resultForStep = dp[i - 2] + 1;
                    resultOperation[i - 1] = i - 2;
                }
                if (i % 3 == 0 && resultForStep >= dp[i / 3 - 1] + 1) {
                    resultForStep = dp[i / 3 - 1] + 1;
                    resultOperation[i - 1] = i / 3 - 1;
                }
                dp[i - 1] = resultForStep;
            }
            i++;
        }
        return dp[n - 1];
    }
}
