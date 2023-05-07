package yandex_1._6;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class E {
    public static void main(String[] args) throws IOException {
        PrintWriter consoleOutput = new PrintWriter(System.out);
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        long a = Long.parseLong(strings.get(0));
        long b = Long.parseLong(strings.get(1));
        long c = Long.parseLong(strings.get(2));

        long low = 0;
        long high = a + b + c;
        long mid = 0;
        long average = (a * 2 + b * 3 + c * 4) * 10 / (a + b + c);
        if (average > 35) {
            consoleOutput.println(0);
        } else {
            while (high - low > 1) {
                mid = (low + high) / 2;
                average = (a * 2 + b * 3 + c * 4 + mid * 5) * 10 / (a + b + c + mid);
                if (average < 35) {
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
