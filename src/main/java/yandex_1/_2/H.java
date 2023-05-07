package yandex_1._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");

        long[] res = new long[3];
        long[] arr = Arrays.stream(s)
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();

        if (arr.length <= 3) {
            res = arr;
        } else {
            long negativeMultiplication = arr[0] * arr[1];
            long multiplication = arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3];
            if (negativeMultiplication > 0 && negativeMultiplication * arr[arr.length - 1] > multiplication) {
                res[0] = arr[0];
                res[1] = arr[1];
                res[2] = arr[arr.length - 1];
            } else {
                res[0] = arr[arr.length - 1];
                res[1] = arr[arr.length - 2];
                res[2] = arr[arr.length - 3];
            }
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(res)
                .forEach(r -> sb.append(r).append(" "));
        System.out.println(sb.toString().trim());
    }
}
