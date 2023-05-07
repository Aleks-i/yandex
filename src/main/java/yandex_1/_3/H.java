package yandex_1._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] s;
        Set<Integer> storage = new HashSet<>();
        for (int i = 0; i < n; i++) {
            s = reader.readLine().split(" ");
            storage.add(Integer.valueOf(s[0]));
        }
        System.out.println(storage.size());
    }
}
