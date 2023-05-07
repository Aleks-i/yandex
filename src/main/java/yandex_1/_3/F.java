package yandex_1._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        Map<String, Integer> genom = getGenoms(reader.readLine());
        Map<String, Integer> genomTarget = getGenoms(reader.readLine());

        for (Map.Entry<String, Integer> entry : genomTarget.entrySet()) {
            String key = entry.getKey();
            if (genom.containsKey(key)) {
                count += genom.get(key);
            }
        }

        System.out.println(count);
    }

    private static Map<String, Integer> getGenoms(String line) {
        Map<String, Integer> res = new TreeMap<>();
        for (int i = 1; i < line.length(); i++) {
            String gen = line.substring(i - 1, i + 1);
            res.computeIfPresent(gen, (k, v) -> v + 1);
            res.putIfAbsent(gen, 1);
        }
        return res;
    }
}
