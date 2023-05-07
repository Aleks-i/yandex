package yandex_1._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");

        int res = 0;
        for (int i = 1; i < s.length - 1; i++) {
            int prev = Integer.parseInt(s[i - 1]);
            int next = Integer.parseInt(s[i + 1]);
            int a = Integer.parseInt(s[i]);
            if (a > prev && a > next) {
                res++;
            }
        }
        System.out.println(res);
    }
}
