package yandex_1._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class I {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Map<String, Integer> languages = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(reader.readLine());
            for (int j = 0; j < m; j++) {
                String language = reader.readLine();
                languages.computeIfPresent(language, (k, v) -> v + 1);
                languages.putIfAbsent(language, 1);
            }
        }
        Set<String> allLanguages = new HashSet<>();
        Set<String> minLanguage = new HashSet<>();
        languages.keySet().forEach(k -> {
            if (languages.get(k) == n) {
                allLanguages.add(k);
            }
            minLanguage.add(k);
        });
        printResult(allLanguages);
        printResult(minLanguage);
    }

    private static void printResult(Set<String> set) {
        System.out.println(set.size());
        set.forEach(System.out::println);
    }
}
