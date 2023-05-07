package yandex_1._6;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter consoleOutput = new PrintWriter(System.out);
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int[] str = Arrays.stream(strings.get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int w = str[0];
        int h = str[1];
        int n = str[2];

        long low = 0;
        long high = (long) Math.max(w, h) * n;
        long mid = 0;
        while (high - low > 1) {
            mid = (high + low) / 2;
            long countW = mid / w;
            long counyH = mid / h;
            if (counyH * countW < n) {
                low = mid;
            } else {
                high = mid;
            }
        }

        consoleOutput.println(high);
        consoleOutput.flush();
        consoleOutput.close();
    }
}
