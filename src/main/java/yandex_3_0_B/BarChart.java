package yandex_3_0_B;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BarChart {
//    public static void main(String[] args) throws IOException {
//        Map<Character, Integer> storage = new TreeMap<>();
//        List<String> lines = Files.readAllLines(Path.of("D:/Programs/HelloWorld/input.txt"));
//        StringBuilder sb = new StringBuilder();
//        lines.forEach(l -> {
//            Arrays.asList(l.split(" ")).forEach(sb::append);
//        });
//
//        int maxCountChars = 0;
//        int amountChar = 0;
//        for(char ch : sb.toString().toCharArray()) {
//            storage.computeIfPresent(ch, (k, v) -> v + 1);
//            if (!storage.containsKey(ch)) {
//                storage.put(ch, 1);
//                amountChar++;
//            }
//            int countChar = storage.get(ch);
//            if (countChar > maxCountChars) {
//                maxCountChars = countChar;
//            }
//        }
//
//        char[][] matrixChars = new char[maxCountChars + 1][amountChar];
//        int i = 0;
//        int j = 0;
//        for (Map.Entry<Character, Integer> entry : storage.entrySet()) {
//            matrixChars[i][j] = entry.getKey();
//            putCountCharInArray(matrixChars, j, entry.getValue());
//            j++;
//        }
//
//        for (int m = maxCountChars; m >= 0; m--) {
//            for (int n = 0; n < amountChar; n++){
//                char ch = matrixChars[m][n];
//                if (m == 0) {
//                    System.out.print(ch);
//                } else if (ch == '#') {
//                    System.out.print(ch);
//                } else {
//                    System.out.print(' ');
//                }
//            }
//            System.out.println();
//        }
//    }
//
//    private static void putCountCharInArray(char[][] chars, int j, int count) {
//        for (int i = 1; i <= count; i++) {
//            chars[i][j] = '#';
//        }
//    }
}
