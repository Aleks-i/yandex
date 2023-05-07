package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BuyingTickets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countBuyers = Integer.parseInt(reader.readLine());

        int[][] timeToBuy = new int[countBuyers + 3][3];
        String[] str = new String[0];
        int[] dp = new int[countBuyers + 3];
        Arrays.fill(dp, 0, 3, 0);
        for (int i = 0; i < timeToBuy.length; i++) {
            if (i > 2) {
                str = reader.readLine().split(" ");
            }
            for (int j = 0; j < timeToBuy[0].length; j++) {
                if (i <= 2) {
                    timeToBuy[i][j] = Integer.MAX_VALUE;
                } else {
                    timeToBuy[i][j] = Integer.parseInt(str[j]);
                }
            }

            if (i > 2) {
                dp[i] = Math.min(dp[i - 1] + timeToBuy[i][0],
                        Math.min(dp[i - 2] + timeToBuy[i - 1][1], dp[i - 3] + timeToBuy[i - 2][2]));
            }
        }

        System.out.println(dp[dp.length - 1]);
//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.deepToString(timeToBuy));
    }
}
