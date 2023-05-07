package yandex_2.B._3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

public class C {
    public static void main(String[] args) throws IOException {
        Integer[] numbers = Arrays.stream(Arrays.stream(Files.readAllLines(Paths.get("input.txt")).get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray())
                .boxed()
                .toArray(Integer[]::new);
        Integer[] sol1 = get1(numbers);
//        Long[] sol = get2(numbers);
//        for (int i = 1; i < 1000; i++) {
//            Integer[] testData = getSeq(i);
//            Integer[] sol1 = get1(testData);
//            Integer[] sol2 = get2(testData);
//            IntStream.range(0, sol2.length).forEach(j -> {
//                if (!Objects.equals(sol1[j], sol2[j])) {
//                    System.out.println(Arrays.deepToString(testData));
//                    System.out.println(Arrays.deepToString(sol1));
//                    System.out.println(Arrays.deepToString(sol2));
//                    System.out.println();
//                }
//            });
//        }
        Arrays.stream(sol1).forEach(e -> System.out.print(e + " "));
    }

    private static Integer[] get1(Integer[] numbers) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> numbersCount = new HashMap<>();
        Arrays.stream(numbers).forEach(n -> {
            numbersCount.computeIfPresent(n, (k, v) -> v + 1);
            numbersCount.putIfAbsent(n, 1);
        });
        Arrays.stream(numbers).forEach(n -> {
            if (numbersCount.get(n) == 1) {
                res.add(n);
            }
        });
        return res.toArray(new Integer[0]);
    }

    private static Integer[] get2(Integer[] numbers) {
        List<Integer> res = new ArrayList<>();
        int[] n = new int[1000000];
        Arrays.stream(numbers).forEach(e -> {
            n[e] += 1;
        });
        Arrays.stream(numbers).forEach(num -> {
            if (n[num] == 1) {
                res.add(num);
            }
        });
        return res.toArray(new Integer[0]);
    }

    private static Integer[] getSeq(int n)   {
        Integer[] res = new Integer[n];
        for (int i = 0; i < n; i++) {
            res[i] = (int) (Math.random() * 10);
        }
        return res;
    }
}
