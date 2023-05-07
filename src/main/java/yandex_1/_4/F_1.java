package yandex_1._4;

import java.io.*;
import java.util.*;

public class F_1 {
    public static void main(String[] args) throws IOException {
        long start;
        double duration;

        start = System.currentTimeMillis();
        PrintWriter consoleOutput = new PrintWriter(System.out);
        Map<String, Map<String, Long>> storage = new TreeMap<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] str = line.split(" ");
            String secondName = str[0];
            storage.putIfAbsent(secondName, new TreeMap<>());
            storage.get(secondName).merge(str[1], Long.valueOf(str[2]), (k, v) -> v + Long.parseLong(str[2]));
        }
        storage.forEach((key, value) -> {
            consoleOutput.println(key + ":");
            value.forEach((key1, value1) -> consoleOutput.println(key1 + " " + value1));
        });

        duration = (System.currentTimeMillis() - start) / 1000.;
        consoleOutput.println(duration);
        consoleOutput.flush();
        consoleOutput.close();
    }
}
