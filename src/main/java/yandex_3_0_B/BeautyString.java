package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BeautyString {
    private static Integer maxBeautyString = 1;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());
        char[] chars = reader.readLine().toCharArray();
//        char[] chars = Files.readAllLines(Path.of("D:/Programs/HelloWorld/input.txt")).get(0).toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        char ch;
        for (char c : alphabet) {
            ch = c;
//            ab

            int idxLeft = 0;
            int idxRight = 0;
            int replacementOperationCountRemainder = k;
            int currentCountSymbol = 0;
            while (idxRight <= chars.length - 1) {
                char charRight = chars[idxRight];
                if (charRight == ch) {
                    currentCountSymbol++;
                    idxRight++;
                    maxBeautyString = Math.max(maxBeautyString, currentCountSymbol);
                } else {
                    replacementOperationCountRemainder--;
                    if (replacementOperationCountRemainder >= 0) {
                        currentCountSymbol++;
                        idxRight++;
                        maxBeautyString = Math.max(maxBeautyString, currentCountSymbol);
                    } else {
                        maxBeautyString = Math.max(maxBeautyString, currentCountSymbol);
                        char charLeft;
                        replacementOperationCountRemainder++;
                        while (replacementOperationCountRemainder != 1 && idxLeft < idxRight) {
                            charLeft = chars[idxLeft];
                            if (charLeft == ch) {
                                currentCountSymbol--;
                                idxLeft++;
                                maxBeautyString = Math.max(maxBeautyString, currentCountSymbol);
                            } else {
                                currentCountSymbol--;
                                idxLeft++;
                                replacementOperationCountRemainder++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(maxBeautyString);
    }
}
