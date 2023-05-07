package yandex_2.B._4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        Map<String, Integer> wordsStorage = new HashMap<>();

        strings.forEach(s -> {
            Arrays.stream(s.split(" ")).forEach(str -> {
                wordsStorage.merge(str, 1, (o, n) -> o + 1);
            });
        });

        Map<Integer, List<String>> countWordsStorage = new HashMap<>();
        wordsStorage.forEach((k, v) -> {
            countWordsStorage.merge(v, new ArrayList<>(Collections.singletonList(k)), (o, n) -> {
                o.add(k);
                return o;
            });
        });

        new TreeMap<>(countWordsStorage).descendingMap().forEach((k, v) -> {
            v.stream()
                    .sorted()
                    .forEach(System.out::println);
        });
    }
}
