package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BoredLecture {
    private static final Map<Character, Long> charsStorage = new HashMap<>();
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] favoriteWord = reader.readLine().toCharArray();

        for (long i = 0; i < favoriteWord.length; i++) {
            Long count = (i + 1) * (favoriteWord.length - i);
            computeCountChars(favoriteWord[(int) i], count);
        }

        printResult();
    }

    private static void computeCountChars(char ch, Long count) {
        charsStorage.putIfAbsent(ch, 0L);
        charsStorage.computeIfPresent(ch, (k, v) -> v + count);
    }

    private static void printResult() {
        for (Character ch : alphabet) {
            if (charsStorage.containsKey(ch)) {
                System.out.println(ch + ": " + charsStorage.get(ch));
            }
        }

    }
}
