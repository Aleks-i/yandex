package yandex_1._1;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class H {
    public static void main(String[] args) throws IOException {
        PrintWriter consoleOutput = new PrintWriter(System.out);
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int a = Integer.parseInt(strings.get(0));
        int b = Integer.parseInt(strings.get(1));
        int n = Integer.parseInt(strings.get(2));
        int m = Integer.parseInt(strings.get(3));
        int minWaiting1 = (n - 1) * a + n;
        int minWaiting2 = (m - 1) * b + m;
        int maxWaiting1 = minWaiting1 + 2 * a;
        int maxWaiting2 = minWaiting2 + 2 * b;
        int minWaiting = Math.max(minWaiting1, minWaiting2);
        int maxWaiting = Math.min(maxWaiting1, maxWaiting2);
        if (maxWaiting < minWaiting) {
            consoleOutput.println(-1);
        } else {
            consoleOutput.println(minWaiting + " " + maxWaiting);
        }
        consoleOutput.flush();
        consoleOutput.close();
    }
}
