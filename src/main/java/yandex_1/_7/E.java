package yandex_1._7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class E {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int k = Integer.parseInt(strings.get(0));
        String[] string = strings.get(1).split(" ");
        int pX = Integer.parseInt(string[0]);
        int pY = Integer.parseInt(string[1]);

        if (pX >= 0 && pY >= 0 && pX + pY <= k) {
            System.out.println(0);
        } else {
            if (pX <= 0 && pY >= 0) {
                if (pY >= k || k - pY < pY) {
                    System.out.println(3);
                } else {
                    System.out.println(1);
                }
            } else if (pX <= 0) {
                System.out.println(1);
            } else if (pY <= 0) {
                if (pX >= k || k - pX < pX) {
                    System.out.println(2);
                } else {
                    System.out.println(1);
                }
            } else {
                if (pX < pY) {
                    System.out.println(3);
                } else {
                    System.out.println(2);
                }
            }
        }
    }
}
