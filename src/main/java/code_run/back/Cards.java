package code_run.back;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.LongStream;


public class Cards {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));

        int n = Integer.parseInt(strings.get(0));
        long[] sumsExistCards = Arrays.stream(strings.get(1).split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long[] res = sol1(n, sumsExistCards);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb.toString().trim());

//        for (int i = 49_000; i < 50_000; i++) {
//            for (int j = 0; j < 1; j++) {
//                List<long[]> testData = getCardsSeqWithMissed(i);
//                long[] cardExisting = testData.get(0);
//                long[] cardMissing = testData.get(1);
//                long[] sumsAll = testData.get(2);
//                long[] sumsExistingCards = testData.get(3);
//
//                long startTime1 = System.nanoTime();
//                long[] sol1MissingCards = sol1(i, sumsExistingCards);
////                long[] sol2 = sol2(i, sumsExistingCards);
//                long endTime1 = System.nanoTime();
//                long duration1 = (endTime1 - startTime1) / 1000000;
//
//                if (duration1 > 500) {
//                    System.out.println("cardsExist: " + Arrays.toString(cardExisting));
//                    System.out.println("cardsMissing: " + Arrays.toString(cardMissing));
//                    System.out.println("t: " + duration1);
//                }
//
//                if (!Arrays.equals(cardMissing, sol1MissingCards)) {
//                    System.out.println("test: " + i + ":");
//                    System.out.println("existCard: " + Arrays.toString(testData.get(0)));
//                    System.out.println("missingCard: " + Arrays.toString(testData.get(1)));
//                    System.out.println("sol1MissingCards: " + Arrays.toString(sol1MissingCards));
//                }
//            }
//        }

//        long[] test = new long[]{1, 2, 3};
//        long[] sol1 = sol1(6, Tester.getSums(Set.of(4L, 5L, 6L)));
//        if (!Arrays.equals(test, sol1)) {
//            System.out.println("missingCard: " + Arrays.toString(test));
//            System.out.println("sol1MissingCards: " + Arrays.toString(sol1));
//        }

//        List<long[]> negativeVar = negativeVar();
//        long[] sumsExistingCards = negativeVar.get(1);
//        long[] sumsMissingCards = negativeVar.get(2);
//        long startTimeN = System.nanoTime();
//        long[] sol1MissingCards = sol1(50_000, sumsExistingCards);
//        long endTimeN = System.nanoTime();
//        long durationN = (endTimeN - startTimeN) / 1000000;
//        System.out.println("nV: " + Arrays.toString(sol1MissingCards));
//        System.out.println("nvT: " + durationN);
    }

    private static long[] sol1(long n, long[] sumsExistingCards) {
        long sums = n * (n + 1) / 2;
        long sumsMissing = sums - sumsExistingCards[0];
        long sumsSquareMissing = (n * (n + 1) * (2 * n + 1)) / 6 - sumsExistingCards[1];
        long sumsCubesMissing = new BigInteger(String.valueOf(sums)).pow(2)
                .subtract(new BigInteger(String.valueOf(sumsExistingCards[2]))).longValue();

        if (sumsExistingCards[0] == 0) {
            return new long[]{1, 2, 3};
        }

        long[] sumsMissingCards = new long[]{sumsMissing, sumsSquareMissing, sumsCubesMissing};
        return searchMissingNumbers(sumsMissingCards, n);
    }

    private static long[] searchMissingNumbers(long[] sumsMissing, long n) {
        long x = 1;
        long y;
        long z;
        for (; x <= sumsMissing[0]; x++) {
            long l = x + 1;
            long h = n;
            long mid;
            while (h - l >= 0) {
                mid = l + (h - l) / 2;
                y = mid;
                z = sumsMissing[0] - x - mid;
                long[] sums = getSumsSol1(x, y, z);
                if (Arrays.equals(sums, sumsMissing)) {
                    long[] res = new long[]{x, y, z};
//                    Arrays.sort(res);
                    return res;
                } else if (sums[1] > sumsMissing[1] && sums[2] > sumsMissing[2]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return new long[]{-1};
    }

    private static long[] getSumsSol1(long x, long y, long z) {
        long sum;
        BigInteger sumSquare;
        BigInteger sumCubes;
        sum = x + y + z;
        sumSquare = (new BigInteger(String.valueOf(x)).pow(2))
                .add(new BigInteger(String.valueOf(y)).pow(2)
                        .add(new BigInteger(String.valueOf(z)).pow(2)));

        sumCubes = (new BigInteger(String.valueOf(x)).pow(3))
                .add(new BigInteger(String.valueOf(y)).pow(3)
                        .add(new BigInteger(String.valueOf(z)).pow(3)));

        return new long[]{sum, sumSquare.longValue(), sumCubes.longValue()};
    }

    private static long[] sol2(long n, long[] sumsWithoutMissing) {
        Set<Long> set = new HashSet<>();
        LongStream.range(1, n + 1).forEach(set::add);
        for (int i = 1; i <= n; i++) {
            set.remove((long) i);
            for (int j = 1; j <= n; j++) {
                set.remove((long) j);
                for (int k = 1; k <= n; k++) {
                    set.remove((long) k);
                    long[] sums = getSumsSol2(i, j, k, n);
                    if (Arrays.equals(sums, sumsWithoutMissing)) {
                        return new long[]{i, j, k};
                    }
                    set.add((long) k);
                }
                set.add((long) j);
            }
            set.add((long) i);
        }
        return new long[]{0};
    }

    private static long[] getSumsSol2(long i, long j, long k, long n) {
        long sum = 0;
        long sumSquare = 0;
        long sumCubes = 0;
        for (int m = 1; m <= n; m++) {
            if (m != i && m != j && m != k) {
                sum += m;
                sumSquare += Math.pow(m, 2);
                sumCubes += Math.pow(m, 3);
            }
        }
        return new long[]{sum, sumSquare, sumCubes};
    }

//    static class Tester {
//
//        public static final long MAX_COUNT_CARDS = 50_000;
//
//        public static List<long[]> getCardsSeqWithMissed(int n) {
//            Set<Long> allCardsSet = new HashSet<>();
//            LongStream.range(1, n + 1).forEach(allCardsSet::add);
//            Set<Long> missingCardsSet = getMissingCards(n);
//            Set<Long> existingCardsSet = new HashSet<>(allCardsSet);
//            existingCardsSet.removeAll(missingCardsSet);
//
//            long[] sumsAll = getSums(allCardsSet);
//            long[] cardsExisting = convertSetToArray(existingCardsSet);
//            long[] cardsMissing = convertSetToArray(missingCardsSet);
//            long[] sumsExistingCards = getSums(existingCardsSet);
//
//            if (sumsExistingCards.length == 0) {
//                return List.of(new long[]{0, 0, 0}, cardsMissing, sumsAll, new long[]{0, 0, 0});
//            }
//            return List.of(cardsExisting, cardsMissing, sumsAll, sumsExistingCards);
//        }
//
//        private static long[] getSums(Set<Long> cards) {
//            long sum = 0;
//            BigInteger sumSquare = new BigInteger("0");;
//            BigInteger sumCubes = new BigInteger("0");
//
//            for (Long i : cards) {
//                sum += i;
//                sumSquare = sumSquare.add(new BigInteger(String.valueOf(i)).pow(2));
//                sumCubes = sumCubes.add(new BigInteger(String.valueOf(i)).pow(3));
//            }
//
//            return new long[]{sum, sumSquare.longValue(), sumCubes.longValue()};
//        }
//
//        private static long[] convertSetToArray(Set<Long> set) {
//            return set.stream()
//                    .mapToLong(Long::longValue)
//                    .sorted()
//                    .toArray();
//        }
//
//        static Set<Long> getMissingCards(long seqLength) {
//            Set<Long> cards = new HashSet<>();
//
//            while (cards.size() != 3) {
//                cards.add(generateNumRange(seqLength));
//            }
//            return cards;
//        }
//
//        private static long generateNumRange(long max) {
//            long num = 0;
//            max = ++max - (long) 1;
//            num = (long) (Math.random() * max) + (long) 1;
//            return num;
//        }
//
//        public static List<long[]> negativeVar() {
//            Set<Long> allCardsSet = new HashSet<>();
//            LongStream.range(1, 50_001).forEach(allCardsSet::add);
//
//            allCardsSet.remove(50_000L);
//            allCardsSet.remove(49_999L);
//            allCardsSet.remove(49_998L);
//
//            long[] sumsExisting = getSums(allCardsSet);
//            long[] sumsMissing = getSums(Set.of(50_000L, 49_999L, 49_998L));
//            return List.of(new long[]{49_998L, 49_999L, 50_000L}, sumsExisting, sumsMissing);
//        }
//    }
}
