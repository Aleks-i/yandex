package yandex_1._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, String> storage = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] s = reader.readLine().split(" ");
            storage.put(s[0], s[1]);
        }
        String target = reader.readLine();
        if (storage.containsKey(target)) {
            System.out.println(storage.get(target));
        } else {
            for (Map.Entry<String, String> entry : storage.entrySet()) {
                if (entry.getValue().equals(target)) {
                    System.out.println(entry.getKey());
                }
            }
        }
    }
}
