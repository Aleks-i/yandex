package yandex_2.B._4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeMap;

public class B {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));

        TreeMap<String, Integer> res = new TreeMap<>();
        strings.forEach(s -> {
            String candidate = s.split(" ")[0];
            int votes = Integer.parseInt(s.split(" ")[1]);
            res.computeIfPresent(candidate, (k, v) -> v + votes);
            res.putIfAbsent(candidate, votes);
        });

        res.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
