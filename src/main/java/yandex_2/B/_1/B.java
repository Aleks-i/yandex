package yandex_2.B._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] string = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = string[0];
        int i = string[1];
        int j = string[2];

        int w1 = Math.abs(i - j) - 1;
        int w2 = n - Math.max(i, j) + Math.min(i, j) - 1;

        System.out.println(Math.min(w1, w2));
    }
}
