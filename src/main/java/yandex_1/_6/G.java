package yandex_1._6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class G {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        long n = Long.parseLong(strings.get(0));
        long m = Long.parseLong(strings.get(1));
        long t = Long.parseLong(strings.get(2));

        long low = 0;
        long high = Math.min(n, m) / 2;
        long mid = 0;
        long countTiles = 0;
        if (n == 3 || m == 3) {
            if (m * 2 + (n - 2) * 2 <= t) {
                low = 1;
            }
        } else {
            while (high - low > 1) {
                mid = low + (high - low) / 2;
                countTiles = mid * m * 2 + mid * (n - mid * 2) * 2;
                if (countTiles <= t) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
        }
        if (Math.min(n, m) - (low + 1) * 2 == 1 && (low + 1) * m * 2 + (low + 1) * (n - (low + 1) * 2) * 2 <= t) {
            low++;
        }
        System.out.println(low);
//        System.out.println(high);
//        System.out.println(mid);
    }
}
