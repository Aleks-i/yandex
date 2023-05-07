package yandex_1._4;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Character.isUpperCase;

public class I {
    public static void main(String[] args) throws IOException {
        PrintWriter consoleOutput = new PrintWriter(System.out);
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        Map<String, Set<Integer>> dictionary = new HashMap<>();
        int cW = Integer.parseInt(strings.get(0));

        IntStream.range(1, cW + 1).forEach(i -> {
            String word = strings.get(i);
            dictionary.putIfAbsent(word.toLowerCase(), new HashSet<>());
            dictionary.get(word.toLowerCase()).addAll(getUpperCaseIndexes(word));
        });

        AtomicInteger countMistakes = new AtomicInteger();
        if (!strings.get(cW + 1).isEmpty()) {
            Arrays.stream(strings.get(cW + 1).split(" ")).forEach(w -> {
                Set<Integer> setUpperIdx = getUpperCaseIndexes(w);
                if (!dictionary.containsKey(w.toLowerCase())) {
                    if (getUpperCaseIndexes(w).size() != 1) {
                        countMistakes.getAndIncrement();
                    }
                } else if (setUpperIdx.size() != 1 || !dictionary.get(w.toLowerCase()).contains(setUpperIdx.iterator().next())) {
                    countMistakes.getAndIncrement();
                }
            });
        }

        consoleOutput.println(countMistakes);
//        dictionary.forEach((k, v) -> {
//            consoleOutput.print(k + ": ");
//            v.forEach(i -> consoleOutput.print(i + " "));
//        });
        consoleOutput.flush();
        consoleOutput.close();
    }

    private static Set<Integer> getUpperCaseIndexes(String word) {
        return IntStream.range(0, word.length())
                .filter(i -> isUpperCase(word.charAt(i)))
                .boxed()
                .collect(Collectors.toSet());
    }
}
