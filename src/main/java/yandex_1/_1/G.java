package yandex_1._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int m = Integer.parseInt(s[2]);

        int countBlank = 0;
        while (n >= k && k >= m) {
            int countK = 0;
            while (n >= k) {
                countK++;
                n -= k;
            }
            int kDiff;
            for (int i = 0; i < countK; i++) {
                kDiff = k;
                while (kDiff >= m) {
                    countBlank++;
                    kDiff -= m;
                }
                n += kDiff;
            }
        }
        System.out.println(countBlank);
    }
}
