package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Carnations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        int[] row = new int[n];

        for (int i = 0; i < str.length; i++) {
            row[i] = (Integer.parseInt(str[i]));
        }

        Arrays.sort(row);
        int[] dp = new int[n];
        dp[1] = row[1] - row[0];
        if (n > 2) {
            dp[2] = row[2] - row[0];
        }
        for (int i = 3; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + row[i] - row[i - 1];
        }

        System.out.println(dp[n - 1]);
    }
}
