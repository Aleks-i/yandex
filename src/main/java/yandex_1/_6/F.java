package yandex_1._6;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class F {
    public static void main(String[] args) throws IOException {
        PrintWriter consoleOutput = new PrintWriter(System.out);
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int n = Integer.parseInt(strings.get(0).split(" ")[0]);
        int x = Integer.parseInt(strings.get(0).split(" ")[1]);
        int y = Integer.parseInt(strings.get(0).split(" ")[2]);

        int low = 0;
        int high = n * Math.max(x, y);
        if (n == 1) {
            consoleOutput.println(Math.min(x, y));
        } else {
            while (high - low > 1) {
                int mid = low + (high - low) / 2;
                int countCopyes = 1;
                int timeReminer = mid - Math.min(x, y);
                countCopyes += timeReminer / x + timeReminer / y;
                if (countCopyes < n) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
            consoleOutput.println(high);
        }
        consoleOutput.flush();
        consoleOutput.close();
    }
}
