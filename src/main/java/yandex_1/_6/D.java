package yandex_1._6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class D {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        long[] vars = Arrays.stream(strings.get(0).split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long n = vars[0];
        long a = vars[1];
        long b = vars[2];
        long w = vars[3];
        long h = vars[4];
        long t = Math.max(process(w, h, a, b, n), process(w, h, b, a, n));
        System.out.println(t);
    }

    private static long process(long w, long h, long a, long b, long n) {
        long low  = 0;
        long high = Math.max(w, h);
        long mid = 0;
        while (high - low > 1) {
            mid = low + (high - low) / 2;
            long cW = w / (a + 2 * mid);
            long cH = h / (b + 2 * mid);
            if (cW * cH >= n) {
                low = mid;
            } else {
                high = mid;
            }
        }
//        System.out.println(low);
        long cWidth = w / (a + 2 * low);
        long cHeigh = h / (b + 2 * low);
        if (cHeigh * cWidth < n || cWidth < 1 || cHeigh < 1) {
            return 0;
        } else {
            return low;
        }
    }
}
