package yandex_2.B._2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class B {
    public static void main(String[] args) throws IOException {
        List<Integer> n = Arrays.stream(Files.readAllLines(Paths.get("input.txt")).get(0).split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxWay = Integer.MIN_VALUE;
        int[] leftDP = getDP(n);
        Collections.reverse(n);
        int[] rightDP = getDP(n);

        for (int i = 0; i < leftDP.length; i++) {
            int eL = leftDP[i];
            int eR = rightDP[rightDP.length - i - 1];
            int w;
            if (eL == 0 || eR == 0) {
                w = Math.max(eL, eR);
            } else {
                w = Math.min(eL, eR);
            }
            maxWay = Math.max(maxWay, w);
        }
        System.out.println(maxWay);
    }

    private static int[] getDP(List<Integer> n) {
        int[] dp = new int[n.size()];
        int[] maxWay = {0};
        final boolean[] isMFound = {false};
        IntStream.range(0, n.size()).forEach(i -> {
            if (isMFound[0]) {
                if (n.get(i) == 2) {
                    maxWay[0] = 0;
                } else if (n.get(i) == 1) {
                    maxWay[0] += 1;
                    dp[i] = maxWay[0];
                } else {
                    maxWay[0] += 1;
                }
            }
            if (n.get(i) == 2) {
                isMFound[0] = true;
            }
        });
        return dp;
    }
}
