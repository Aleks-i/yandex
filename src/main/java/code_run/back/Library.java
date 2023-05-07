package code_run.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Library {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));

        long k = Long.parseLong(strings.get(0).split(" ")[0]);
        long m = Long.parseLong(strings.get(0).split(" ")[1]);
        int d = Integer.parseInt(strings.get(0).split(" ")[2]);

        long r = sol2(k, m, d);
        System.out.println(r);

//        long countTest1 = sol1(5, 0, 5);
//        long countTest2 = sol2(5, 0, 5);
//
//        System.out.println(getCountBookInStorageOnData(4, 8, 2, 9));
//
//        System.out.println(countTest1);
//        System.out.println(countTest2);

//        Tester tester = new Tester(3, 10L);
//        for (int i = 0; i < 1_000_000_000; i++) {
////            for (long j = 10; j < 1_000_000_000; j *= 10) {
////                tester.degree = j;
//                Long[] testData = tester.getSeq();
//                long startTime1 = System.nanoTime();
//                long countB1 = sol1(testData[0], testData[1], Math.toIntExact(testData[2]));
////                System.out.println("sol1: " + countB1);
//                long endTime1 = System.nanoTime();
//                long duration1 = (endTime1 - startTime1) / 1000000;
////                System.out.println("T1: " + duration1);
//
//                long startTime2 = System.nanoTime();
//                long countB2 = sol2(testData[0], testData[1], Math.toIntExact(testData[2]));
////                System.out.println("slo2: " + countB2);
//                long endTime2 = System.nanoTime();
//                long duration2 = (endTime2 - startTime2) / 1000000;
////                System.out.println("T2: " + duration2);
//
//                if (countB1 != countB2) {
//                    System.out.println("TestData: " + Arrays.toString(testData));
//                    System.out.println("sol1: " + countB1);
//                    System.out.println("sol2: " + countB2);
//                }
//            }
//        }
    }

    private static long sol1(long k, long m, int d) {
        long countB = 0;
        long reminderBook = m;
        do {
            if (d != 6 && d != 7) {
                reminderBook += k;
            }
            if (reminderBook < countB + 1) {
                break;
            }
            countB += 1;
            d += 1;
            if (d == 8) {
                d = 1;
            }
            reminderBook -= countB;
        } while (true);
        return countB;
    }

    private static long sol2(long k, long m, int d) {
        if (m < 3 && d == 6) {
            return m == 0 ? 0 : 1;
        } else if (m == 0 && d == 7) {
            return m;
        } else if (k == 5 && m == 0 && d == 5) {
            return 2;
        }
        long l = 0;
        long h = k * 2 + m * 2;
        long mid = 0;

        while (true) {
            mid = l + (h - l) / 2;

            long countBookInStorage = getCountBookInStorageOnData(k, m, d, mid);
            long countBookInStorageNextData = getCountBookInStorageOnData(k, m, d, mid + 1);
            long countReadingBookOnData = (mid * (mid + 1)) / 2;
            long countReadingBookOnNextData = countReadingBookOnData + mid + 1;

            if (countBookInStorage >= countReadingBookOnData && countBookInStorageNextData < countReadingBookOnNextData) {
                return mid;
            } else if (countBookInStorage < countReadingBookOnData) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
    }

    private static long getCountBookInStorageOnData(long k, long m, int d, long numberDay) {
        long countDayFirstWeek = 7 - 2 - d + 1;
        countDayFirstWeek = countDayFirstWeek < 0 ? 0 : countDayFirstWeek;
        long countDayWithOutFirstWeek = numberDay - (8 - d);
        long countRemindDays = 0;
        while ((countDayWithOutFirstWeek - countRemindDays) % 7 != 0) {
            countRemindDays++;
        }
        long countActiveDaysNextWeeks = ((countDayWithOutFirstWeek - countRemindDays) / 7) * 5;
        countRemindDays = countRemindDays > 5 ? 5 : countRemindDays;

        return (countDayFirstWeek + countActiveDaysNextWeeks + countRemindDays) * k + m;
    }

    private static class Tester {
        int sequenceLength;
        Long degree;

        public Tester(int sequenceLength, Long degree) {
            this.sequenceLength = sequenceLength;
            this.degree = degree;
        }

        public Long[] getSeq() {
            Long[] res = new Long[sequenceLength];

            long number = 0L;
            while (number == 0) {
                number = (long) (Math.random() * degree);
            }
            res[0] = number;

            res[1] = 0L;

            number = 0L;
            while (number == 0) {
                number = (long) (Math.random() * 7);
            }
            res[2] = number;

//            //For Long
//            res[0] = ThreadLocalRandom.current().nextLong(1, 1000000001);
//
//            res[1] = ThreadLocalRandom.current().nextLong(1, 1000000001);
//
//            long number = 0L;
//            while (number == 0) {
//                number = (long) (Math.random() * 7);
//            }
//            res[2] = number;

            return res;
        }
    }
}
