package yandex_1._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");

        long[] res;
        long[] arr = Arrays.stream(s)
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();

        if (arr[0] * arr[1] > arr[arr.length - 1] * arr[arr.length - 2]) {
            res = new long[]{arr[0], arr[1]};
        } else {
            res = new long[]{arr[arr.length - 2], arr[arr.length - 1]};
        }
        System.out.println(res[0] + " " + res[1]);
    }
}
