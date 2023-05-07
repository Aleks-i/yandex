package yandex_1._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        final int[] throwingRange = {Integer.MIN_VALUE};
        final int[] winnerRange = {Integer.MIN_VALUE};
        int[] throwingRanges = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .peek(e -> winnerRange[0] = Math.max(winnerRange[0], e))
                .toArray();
        int idxWinner = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (throwingRanges[i] == winnerRange[0]) {
                idxWinner = i;
            }
        }

        for (int i = n - 2; i > 0; i--) {
            if (throwingRanges[i] % 10 == 5 && throwingRanges[i] > throwingRanges[i + 1] && i > idxWinner) {
                throwingRange[0] = Math.max(throwingRanges[i], throwingRange[0]);
            }
        }

        if (winnerRange[0] == throwingRange[0]) {
            System.out.println(1);
        } else if (throwingRange[0] == Integer.MIN_VALUE) {
            System.out.println(0);
        } else {
            int idx = throwingRanges.length - 1;
            Arrays.sort(throwingRanges);
            while (throwingRanges[idx] != throwingRange[0]) {
                idx--;
            }
            System.out.println(throwingRanges.length - idx);
        }
    }
}
