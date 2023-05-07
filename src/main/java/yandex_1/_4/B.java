package yandex_1._4;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B {
//    public static void main(String[] args) throws IOException {
//        long startTime = System.nanoTime();
//        List<String> stringList = Files.readAllLines(Paths.get("input.txt"));
//        Map<String, Integer> storage = new HashMap<>();
//        PrintWriter consoleOutput = new PrintWriter(System.out);
//        stringList.forEach(s -> {
//            Arrays.asList(s.split(" ")).forEach(w -> {
//                if (!w.isBlank()) {
//                    storage.computeIfPresent(w, (k, v) -> v + 1);
//                    storage.putIfAbsent(w, 0);
//                    consoleOutput.print(storage.get(w) + " ");
//                }
//            });
//        });
////        long endTime = System.nanoTime();
////        consoleOutput.println();
////        consoleOutput.println((endTime - startTime) / 1_000_000);
//        consoleOutput.flush();
//        consoleOutput.close();
//    }
}
