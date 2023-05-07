package code_run.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PalletsStock {
    public static void main(String[] args) throws IOException {
//        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
//        int n = Integer.parseInt(strings.get(0));
//
//        long count = sol3(strings, n);
//        System.out.println(count);

        Tester tester = new Tester(2, 300_000, 1_000_000_000L);
        List<String> testData;
        for (int i = 0; i < 10; i++) {
             testData = tester.getSeq();

            long startTime1 = System.nanoTime();
            long sol1 = sol1(testData, Integer.parseInt(testData.get(0)));
            long endTime1 = System.nanoTime();
            long duration1 = (endTime1 - startTime1) / 1000000;
            System.out.println("T1: " + duration1);

            long startTime3 = System.nanoTime();
            long sol3 = sol3(testData, Integer.parseInt(testData.get(0)));
            long endTime3 = System.nanoTime();
            long duration3 = (endTime3 - startTime3) / 1000000;
            System.out.println("T3: " + duration3);

            if (sol1 != sol3) {
                System.out.println("TestData: " + testData.toString());
                System.out.println("sol1: " + sol1);
                System.out.println("sol3: " + sol3);
            }
        }

//        long startTime = System.nanoTime();
//        testData = tester.getSeq();
//        long sol3 = sol3(testData, Integer.parseInt(testData.get(0)));
//        System.out.println("sol3: " + sol3);
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime) / 1000000;
//        System.out.println("T3: " + duration);

//        List<String> test = new ArrayList<>();
//        test.add("4");
//        test.add("3 3");
//        test.add("1 2");
//        test.add("3 1");
//        test.add("4 1");
//
//        long sol2 = sol2(test, 4);
//        long sol3 = sol3(test, 4);
//        System.out.println(sol2);
//        System.out.println(sol3);
    }

    private static long sol1(List<String> strings, int n) {
        TreeMap<Long, List<Stock>> stocksMap = strings.stream()
                .skip(1)
                .map(s -> s.split(" "))
                .map(hw -> new Stock(Long.parseLong(hw[0]), Long.parseLong(hw[1])))
                .collect(Collectors.groupingBy(Stock::getH,
                        () -> new TreeMap<>(Comparator.reverseOrder()),
                        Collectors.toCollection(ArrayList::new)));

        long count = 0;
        long prewW = 0;
        for (Map.Entry<Long, List<Stock>> e : stocksMap.entrySet()) {
            List<Stock> stockList = e.getValue();

            long finalPrewW = prewW;
            count += stockList.stream()
                    .filter(s -> s.w >= finalPrewW)
                    .count();

            prewW = Math.max(stockList.get(0).w, prewW);
        }
        return count;
    }

//    private static long sol2(List<String> strings, int n) {
//        List<long[]> arrs = strings.stream()
//                .skip(1)
//                .map(s -> Arrays.stream(s.split(" ")).mapToLong(Long::parseLong).toArray())
//                .collect(Collectors.toList());
//
//        long count = 0;
//        for (int i = 0; i < arrs.size(); i++) {
//            boolean isBigger = true;
//            long[] stockCurr = arrs.get(i);
//            for (int j = 0; j < arrs.size(); j++) {
//                if (i != j) {
//                    long[] stockNext = arrs.get(j);
//                    if ((stockCurr[0] < stockNext[0] && stockCurr[1] < stockNext[1])
//                            || (stockCurr[0] < stockNext[1] && stockCurr[1] < stockNext[0])) {
//                        isBigger = false;
//                    }
//                }
//            }
//            if (isBigger) {
//                count++;
//            }
//        }
//        return count;
//    }

    private static long sol3(List<String> strings, int n) {
        strings.remove(0);
        TreeMap<Long, List<Long>> storage = new TreeMap<>(Comparator.reverseOrder());

        String[] arr;
        List<Long> widthListStart;

        for (String s : strings) {
            arr = s.split(" ");
            LongSummaryStatistics hw = Stream.of(arr[0], arr[1])
                    .collect(Collectors.summarizingLong(Long::parseLong));
            long h = hw.getMax();
            long w = hw.getMin();
            widthListStart = new ArrayList<>();
            widthListStart.add(w);
            storage.merge(h, widthListStart, (o1, o2) -> {
                o1.add(w);
                return o1;
            });
        }

        long count = 0;
        long prewW = 0;

        long maxWidthElement = 0;
        Long firstH = storage.firstKey();
        for (Map.Entry<Long, List<Long>> e : storage.entrySet()) {
            List<Long> widthList = e.getValue();

            for (Long w : widthList) {
                if (w >= prewW || Objects.equals(e.getKey(), firstH)) {
                    count++;
                }
                maxWidthElement = Math.max(w, maxWidthElement);
            }
            prewW = Math.max(prewW, maxWidthElement);
        }
        return count;
    }

    private static class Stock {

        private static int ID_COUNTER = 0;

        int id;
        long h;
        long w;

        public Stock(long a, long b) {
            this.id = ++ID_COUNTER;
            this.h = Math.max(a, b);
            this.w = Math.min(a, b);
        }

        public int getId() {
            return id;
        }

        public long getH() {
            return h;
        }

        public long getW() {
            return w;
        }
    }

    private static class Tester {
        int sequenceLength;
        int countString;
        Long degree;

        public Tester(int sequenceLength, int countString, Long degree) {
            this.sequenceLength = sequenceLength;
            this.countString = countString;
            this.degree = degree;
        }

        public List<String> getSeq() {
            List<String> res = new ArrayList<>();
            res.add(String.valueOf(countString));

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < countString + 1; i++) {

                long number = 0L;
                for (int j = 0; j < 2; j++) {
                    while (number == 0) {
                        number = (long) (Math.random() * degree);
                    }
                    sb.append(number).append(" ");
                    sb.trimToSize();
                    number = 0;
                }
                res.add(sb.toString().trim());
                sb.setLength(0);
            }
//            //For Long
//            arr[0] = ThreadLocalRandom.current().nextLong(1, 1000000001);
//
//            arr[1] = ThreadLocalRandom.current().nextLong(1, 1000000001);
//
//            long number = 0L;
//            while (number == 0) {
//                number = (long) (Math.random() * 7);
//            }
//            arr[2] = number;
            return res;
        }
    }
}
