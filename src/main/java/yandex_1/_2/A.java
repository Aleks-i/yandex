package yandex_1._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");

        boolean increas = true;
        for (int i = 0; i < s.length; i++) {
            if (i != 0) {
                if (Integer.parseInt(s[i - 1]) >= Integer.parseInt(s[i])) {
                    increas = false;
                }
            }
        }
        if (increas) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
