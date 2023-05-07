package yandex_1._6;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class H {
    public static void main(String[] args) throws IOException {
        PrintWriter consoleOutput = new PrintWriter(System.out);
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int k = Integer.parseInt(strings.get(0).split(" ")[1]);
        strings.remove(0);
        int[] s = strings.stream()
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int low = 0;
        int high = s[s.length - 1] + 1;
        int mid = 0;
        int countSegment = 0;
        while (high - low > 1) {
            mid = low + (high - low) / 2;
            countSegment = 0;
            for (int j : s) {
                countSegment += j / mid;
            }
            if (countSegment >= k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        consoleOutput.println(low);
//        consoleOutput.println(mid);
//        consoleOutput.println(high);
//        consoleOutput.println(Arrays.toString(s));
        consoleOutput.flush();
        consoleOutput.close();
    }
}
