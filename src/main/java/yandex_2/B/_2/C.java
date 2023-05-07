package yandex_2.B._2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C {
    public static void main(String[] args) throws IOException {
        char[] str = Files.readAllLines(Paths.get("input.txt")).get(0).toCharArray();

        int cost = 0;
        int i = 0;
        int j = str.length - 1;

        while (i < j) {
            if (str[i] != str[j]) {
                cost++;
            }
            i++;
            j--;
        }
        System.out.println(cost);
    }
}
