package yandex_1._6;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class I {
    public static void main(String[] args) throws IOException {
        PrintWriter consoleOutput = new PrintWriter(System.out);
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        String[] str = strings.get(0).split(" ");
        int n = Integer.parseInt(str[0]);
        int r = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);
        strings.remove(0);
        int[] heights = strings.stream()
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int low = 0;
        int high = heights[heights.length - 1] - heights[0];
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            int i = 0;
            int rC = 0;
            while (i < heights.length - c + 1) {
                if (heights[i + c - 1] - heights[i] <= mid) {
                    rC++;
                    i += c;
                } else {
                    i++;
                }
            }
            if (rC < r) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        consoleOutput.println(low);
//        consoleOutput.println(mid);
//        consoleOutput.println(high);
//        consoleOutput.println(Arrays.toString(heights));
        consoleOutput.flush();
        consoleOutput.close();
    }
}
