package yandex_1._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);
        int d = Integer.parseInt(s[3]);

        TreeMap<Integer, List<Integer>> squareStorage = new TreeMap<>();
        fillStorage(a, b, c, d, squareStorage);
        fillStorage(a, b, d, c, squareStorage);
        fillStorage(b, a, c, d, squareStorage);
        fillStorage(b, a, d, c, squareStorage);
        IntStream.range(0, 2).forEach(i -> System.out.print(squareStorage.get(squareStorage.firstKey()).get(i) + " "));
    }

    private static void fillStorage(int a, int b, int c, int d, Map<Integer, List<Integer>> squareStorage) {
        int w = Math.max(a, c);
        int h = b + d;
        int s = w * h;
        squareStorage.putIfAbsent(s, new ArrayList<>());
        squareStorage.computeIfPresent(s, (k, v) -> {
            v.add(w);
            v.add(h);
            return v;
        });
    }
}
