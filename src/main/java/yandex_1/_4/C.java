package yandex_1._4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class C {
//    public static void main(String[] args) throws IOException {
//        List<String> stringList = Files.readAllLines(Paths.get("input.txt"));
//        final int[] countMaxRepeat = {0};
//        final Set<String>[] set = new Set[]{new TreeSet<>()};
//        Map<String, Integer> storage = new HashMap<>();
//        stringList.forEach(s -> {
//            Arrays.asList(s.split(" ")).forEach(w -> {
//                if (!w.isBlank()) {
//                    storage.computeIfPresent(w, (k, v) -> v + 1);
//                    storage.putIfAbsent(w, 1);
//                    if (storage.get(w) == countMaxRepeat[0]) {
//                        set[0].add(w);
//                    } else if (storage.get(w) > countMaxRepeat[0]) {
//                        countMaxRepeat[0] = storage.get(w);
//                        set[0] = new TreeSet<>();
//                        set[0].add(w);
//                    }
//                }
//            });
//        });
//        System.out.println(set[0].iterator().next());
//    }
}
