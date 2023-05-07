package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Canteen {
    static int inf = 1_000_000;
    static int[][] dp;
    static int[] lunchPrices;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k1 = 0;
        int k2 = 0;
        lunchPrices = new int[n + 1];
        for (int i = 1; i <= n; i++) lunchPrices[i] = Integer.parseInt(reader.readLine());
        dp = new int[n + 1][n + 2];
        for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], -1);
        }

        int ans = inf;

        for (int i = 0; i <= n; i++) {
            if (ans >= fillDP(n, i)) {
                ans = fillDP(n, i);
                k1 = i;
            }
        }

        System.out.println(ans);

        ArrayDeque<Integer> used = new ArrayDeque<>();
        countUsedCoupon(used, n, k1);
        k2 = used.size();

        System.out.println(k1 + " " + k2);

        while (!used.isEmpty()) {
            System.out.print(used.removeLast() + "\n");
        }
    }

    static int fillDP(int i, int j) {
        if (j > i) return inf;
        else {
            int res;
            int cost = lunchPrices[i];
            if (j <= 0) {
                if (i >= 1) {
                    if (cost <= 100) {
                        res = Math.min(fillDP(i - 1, j + 1), fillDP(i - 1, j) + cost);
                    } else {
                        return fillDP(i - 1, j + 1);
                    }
                } else return 0;
            } else {
                if (dp[i][j] != -1) return dp[i][j];
                if (cost > 100) {
                    res = Math.min(fillDP(i - 1, j + 1), fillDP(i - 1, j - 1) + cost);
                } else {
                    res = Math.min(fillDP(i - 1, j + 1), fillDP(i - 1, j) + cost);
                }
            }
            dp[i][j] = res;
            return res;
        }
    }

    static void countUsedCoupon(ArrayDeque<Integer> used, int i, int j) {
        if (j < i) {
            int cost = lunchPrices[i];
            if (j <= 0) {
                if (i >= 1) {
                    if (cost > 100) {
                        used.add(i);
                        countUsedCoupon(used, i - 1, j + 1);
                    } else {
                        boolean addi = (fillDP(i, j) == fillDP(i - 1, j + 1));
                        if (addi) {
                            used.add(i);
                            countUsedCoupon(used, i - 1, j + 1);
                        } else countUsedCoupon(used, i - 1, j);
                    }
                }
            } else {
                if (cost <= 100) {
                    boolean addi = (fillDP(i - 1, j + 1) == fillDP(i, j));
                    if (addi) {
                        used.add(i);
                        countUsedCoupon(used, i - 1, j + 1);
                    } else {
                        countUsedCoupon(used, i - 1, j);
                    }
                } else {
                    boolean addi = (fillDP(i - 1, j + 1) == fillDP(i, j));
                    if (addi) {
                        used.add(i);
                        countUsedCoupon(used, i - 1, j + 1);
                    } else {
                        countUsedCoupon(used, i - 1, j - 1);
                    }
                }
            }
        }
    }
}
