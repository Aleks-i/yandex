package yandex_1._3;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class G {
    public static void main(String[] args) throws IOException {
        PrintWriter consoleOutput = new PrintWriter(System.out);
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int n = Integer.parseInt(strings.get(0));
        Set<Integer> turtles = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            int[] turtle = Arrays.stream(strings.get(i).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (!turtles.contains(turtle[0]) && turtle[0] + turtle[1] == n - 1 && turtle[0] >= 0 && turtle[1] >= 0) {
                turtles.add(turtle[0]);
            }
        }
        consoleOutput.println(turtles.size());
        consoleOutput.flush();
        consoleOutput.close();
    }
}
