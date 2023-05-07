package code_run.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FrequentElement {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        long max1 = sol1(Arrays.stream(strings.get(1).split(" "))
                .mapToLong(Long::parseLong)
                .toArray());

//        long max2 = sol2(Arrays.stream(strings.get(1).split(" "))
//                .mapToLong(Long::parseLong)
//                .toArray());

//        for (int i = 1; i < 10000; i++) {
//            for (long j = 10; j < 1000000000000L; j = j * 10) {
//                long[] testData = getSeq(i, j);
//                long sol1 = sol1(testData);
//                long sol2 = sol2(testData);
//                if (!Objects.equals(sol1, sol2)) {
//                    System.out.println(Arrays.toString(testData));
//                    System.out.println("sol1 " + sol1);
//                    System.out.println("sol2 " + sol2);
//                    System.out.println();
//                }
//            }
//        }
        System.out.println(max1);
    }

    private static long sol1(long[] strings) {
        Map<Long, Long> maxMap = Arrays.stream(strings)
                .boxed()
                .collect(groupingBy(Function.identity(), counting()));

        long max = Long.MIN_VALUE;
        long maxCount = 0;
        for (Map.Entry<Long, Long> e : maxMap.entrySet()) {
            if (e.getValue() > maxCount) {
                maxCount = e.getValue();
                max = e.getKey();
            } else if (e.getValue() == maxCount) {
                max = Math.max(max, e.getKey());
            }
        }
        return max;
    }

    private static long sol2(long[] nums) {
        Map<Long, Long> storage = new HashMap<>();

        for (long num : nums) {
            storage.computeIfPresent(num, (k, v) -> v + 1);
            storage.putIfAbsent(num, 1L);
        }

        long maxCount = 0;
        for (Map.Entry<Long, Long> e : storage.entrySet()) {
            if (e.getValue() >= maxCount) {
                maxCount = e.getValue();
            }
        }

        long max = 0;
        for (Map.Entry<Long, Long> e : storage.entrySet()) {
            if (e.getValue() == maxCount && e.getKey() > max) {
                max = e.getKey();
            }
        }
        return max;
    }

    private static long[] getSeq(int n, long multiplicity) {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            long number = 0;
            while (number == 0){
                number = (long) (Math.random() * multiplicity);
            }
            res[i] = number;
        }
        return res;
    }
}
