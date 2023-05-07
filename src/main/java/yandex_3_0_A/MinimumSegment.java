package yandex_3_0_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;

public class MinimumSegment {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        str = reader.readLine().split(" ");

        long startTime = System.nanoTime();
        int[] subsequence = new int[n];
        int[] dp = new int[n - k + 1];
        int idxK = k;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int e = Integer.parseInt(str[i]);
            if (idxK - 1 > i) {
                while (!queue.isEmpty() && subsequence[queue.getFirst()] > e) {
                    queue.pollFirst();
                }
                subsequence[i] = e;
                queue.addFirst(i);
            } else if (idxK - 1 == i) {
                idxK++;
                while (!queue.isEmpty() && subsequence[queue.getFirst()] > e) {
                    queue.pollFirst();
                }
                subsequence[i] = e;
                queue.addFirst(i);
                dp[i - k + 1] = queue.getLast();
                if (queue.getLast() == i - k + 1) {
                    queue.pollLast();
                }
            }
        }

        PrintWriter consoleOutput = new PrintWriter(System.out);
        for (int j : dp) {
            consoleOutput.println(subsequence[j]);
        }

//        long endTime = System.nanoTime();
//        consoleOutput.println(TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS));

        consoleOutput.flush();
        consoleOutput.close();
    }
}
