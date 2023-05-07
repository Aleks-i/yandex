package yandex_1._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");

        Set<String> set = new HashSet<>();
        int res = 0;
        for (String s : str) {
            if (!set.contains(s)) {
                set.add(s);
                res++;
            }
        }

        System.out.println(res);
    }
}
