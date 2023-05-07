package yandex_2.B._3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class D {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int n = Integer.parseInt(strings.get(0));
        strings.remove(0);

        Set<Integer> res = new HashSet<>();
        IntStream.range(1, n + 1).forEach(res::add);
        Set<Integer> numbers;
        String s = strings.get(0);
        int i = 0;
        while (!s.equals("HELP")) {
            numbers = Arrays.stream(Arrays.stream(s.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray())
                    .boxed()
                    .collect(Collectors.toSet());
            if ("YES".equals(strings.get(i + 1))) {
                res = res.stream()
                        .filter(numbers::contains)
                        .collect(Collectors.toSet());
            } else {
                numbers.forEach(res::remove);
            }
            i = i + 2;
            s = strings.get(i);
        }
        new TreeSet<>(res).forEach(num -> System.out.print(num + " "));
    }
}
