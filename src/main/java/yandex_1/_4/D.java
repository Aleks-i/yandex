package yandex_1._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] clickLimit = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = Integer.parseInt(reader.readLine());
        int[] clickCount = new  int[n];
        Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .peek(e -> {
                    clickCount[e - 1]++;
                })
                .toArray();
        String res = "";
        for (int i = 0; i < clickLimit.length; i++) {
            if (clickCount[i] > clickLimit[i]) {
             res = "YES";
            } else {
                res = "NO";
            }
            System.out.println(res);
        }
    }
}
