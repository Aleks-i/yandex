package yandex_1._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        AtomicLong maxHeight = new AtomicLong();
        Map<Integer, Set<Integer>> storage = new TreeMap<>(Collections.reverseOrder());
        String[] s;
        for (int i = 0; i < n; i++) {
            s = reader.readLine().split(" ");
            int w = Integer.parseInt(s[0]);
            int h = Integer.parseInt(s[1]);
            storage.putIfAbsent(w, new TreeSet<>(Collections.reverseOrder()));
            storage.get(w).add(h);
        }

        storage.forEach((key, value) -> maxHeight.addAndGet(value.iterator().next()));
        System.out.println(maxHeight);
    }
}
