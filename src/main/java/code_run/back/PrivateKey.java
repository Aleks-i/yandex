package code_run.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PrivateKey {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        long[] elements = Arrays.stream(strings.get(0).split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

//        for (int i = 1; i < 10000; i++) {
//            for (long j = 10; j < 1000L; j = j * 10) {
//                Long[] testData = getSeq(2, j);
//                long sol1 = sol1(testData[0], testData[1]);
//                long sol2 = sol2(testData[0], testData[1]);
//                if (!Objects.equals(sol1, sol2)) {
//                    System.out.println(Arrays.deepToString(testData));
//                    System.out.println("sol1 " + sol1);
//                    System.out.println("sol2 " + sol2);
//                    System.out.println();
//                }
//            }
//        long ans = sol1(3, 90);
        long ans1 = sol2(elements[0], elements[1]);
        System.out.println(ans1);
//        }
    }

    private static long sol1(long a, long b) {
        long ans = 0;
        if (b % a != 0) {
            return ans;
        } else if (a == b) {
            return 1;
        } else {
            b /= a;

            for (long i = 2; i * i <= b; ++i) {
                if (b % i == 0) {
                    ++ans;
                    while (b % i == 0) {
                        b /= i;
                    }
                }
            }
            if (b != 1) {
                ++ans;
            }
        }
        return ans * 2L;
    }

    private static long sol2(long a, long b) {
        long ans = 0;
        if (a == b) {
            return 1;
        } else if (b % a != 0) {
            return 0;
        } else {
            b /= a;

            for (long i = 1; i * i <= b; ++i) {
                if (b % i == 0) {
                    if (gcd(i, b / i) == 1) {
                        ans += 1 + (i * i != b ? 1 : 0);
                    }
                }
            }
        }

        return ans;
    }

    private static long gcd(long a, long b) {
        return Stream.iterate(new long[]{a, b}, vals -> new long[]{vals[1], vals[0] % vals[1]})
                .filter(v -> v[1] == 0)
                .findFirst()
                .get()[0];
    }

    private static Long[] getSeq(int n, long multiplicity) {
        Long[] res = new Long[n];
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
