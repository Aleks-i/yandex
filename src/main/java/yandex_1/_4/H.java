package yandex_1._4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class H {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int[] string = Arrays.stream(strings.get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int g = string[0];
        int s = string[1];
        Map<Character, Integer> w = getwordMap(strings.get(1).toCharArray());
        Map<Character, Integer> res = new HashMap<>();
        char[] str = strings.get(2).toCharArray();
        int f = 0;
        int l = -1;
        int counChar = 0;
        while (l < g - 1) {
            l++;
            char ch = str[l];
            if (w.containsKey(ch)) {
                res.computeIfPresent(ch, (k, v) -> v + 1);
                res.putIfAbsent(ch, 1);
                if (Objects.equals(res.get(ch), w.get(ch))) {
                    counChar++;
                }
            }
        }
        int countAccord = 0;
        if (counChar == w.size()) {
            countAccord++;
        }
        while (l < s - 1) {
            char chF = str[f];
            if (res.containsKey(chF)) {
                if (Objects.equals(res.get(chF), w.get(chF))) {
                    counChar--;
                }
                if (res.get(chF) == 1) {
                    res.remove(chF);
                } else {
                    res.compute(chF, (k, v) -> v - 1);
                }
            }
            f++;
            l++;
            char chL = str[l];
            if (w.containsKey(chL)) {
                res.computeIfPresent(chL, (k, v) -> v + 1);
                res.putIfAbsent(chL, 1);
                if (Objects.equals(res.get(chL), w.get(chL))) {
                    counChar++;
                }
            }
            if (counChar == w.size()) {
                countAccord++;
            }
        }
        System.out.println(countAccord);
//        res.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static Map<Character, Integer> getwordMap(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars) {
            map.computeIfPresent(ch, (k, v) -> v + 1);
            map.putIfAbsent(ch, 1);
        }
        return map;
    }
}
