package yandex_2.B._2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class A {
    public static void main(String[] args) throws IOException {
        int[] n = Files.readAllLines(Paths.get("input.txt")).stream()
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int l = 0;
        int r = n.length - 1;
        int m = 0;
        while (r - l != 0) {
            m = l + (r - l) / 2;
            if (n[m] < n[n.length - 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (n[n.length - 1] == 0) {
            r++;
        }
        System.out.println(n.length - r);
    }
}
