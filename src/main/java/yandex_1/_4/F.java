package yandex_1._4;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class F {
    public static void main(String[] args) throws IOException {
        PrintWriter consoleOutput = new PrintWriter(System.out);

        long start;
        double duration;
        List<Double> runTime = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            start = System.currentTimeMillis();
            process();
            duration = (System.currentTimeMillis() - start) / 1000.;
            runTime.add(duration);
        }
        runTime.forEach(consoleOutput::println);
        consoleOutput.flush();
        consoleOutput.close();
    }

    private static void process() throws IOException {
        PrintWriter fileOutput = new PrintWriter("output.txt");

        final Map<String, Map<String, Long>> storage = new TreeMap<>();
        Files.readAllLines(Paths.get("input.txt")).forEach(s -> {
            String[] str = s.split(" ");
            String secondName = str[0];
            storage.putIfAbsent(secondName, new TreeMap<>());
            Map<String, Long> productStorage = storage.get(secondName);
            productStorage.computeIfPresent(str[1], (k, v) -> Long.valueOf(v + str[2]));
            productStorage.putIfAbsent(str[1], Long.valueOf(str[2]));
        });
        storage.forEach((key, value) -> {
            fileOutput.println(key + ":");
            value.forEach((key1, value1) -> fileOutput.println(key1 + " " + value1));
        });
        fileOutput.flush();
        fileOutput.close();
    }
}
