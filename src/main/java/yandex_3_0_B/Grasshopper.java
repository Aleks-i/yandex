package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Grasshopper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        long startTime = System.nanoTime();
        int[] fiboStorage = new int[n];
        System.out.println(getFibo(n, k, fiboStorage));
        long endTime = System.nanoTime();
//        System.out.println(TimeUnit.SECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS));

    }

    private static int getFibo(int n, int k, int[] fiboStorage) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n <= 0) return 0;
        int sum = 0;
        if (fiboStorage[n - 1] != 0) {
            sum = fiboStorage[n - 1];
        } else {
            for (int i = 1; i <= k; i++) {
                sum += getFibo(n - i, k, fiboStorage);
            }
        }
        fiboStorage[n - 1] = sum;
        return sum;
    }
}
