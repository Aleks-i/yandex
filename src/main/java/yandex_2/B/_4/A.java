package yandex_2.B._4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeMap;

public class A {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int n = Integer.parseInt(strings.get(0));
        strings.remove(0);

        TreeMap<Long, Long> res = new TreeMap<>();
        strings.forEach(str -> {
            long color = Long.parseLong(str.split(" ")[0]);
            long num = Long.parseLong(str.split(" ")[1]);
            res.computeIfPresent(color, (k, v) -> v + num);
            res.putIfAbsent(color, num);
        });

        res.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
