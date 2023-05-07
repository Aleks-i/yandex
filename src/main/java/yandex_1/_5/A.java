package yandex_1._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countS = Integer.parseInt(reader.readLine());
        String[] strColorsShirt = reader.readLine().split(" ");
        int countP = Integer.parseInt(reader.readLine());
        String[] strColorsPants = reader.readLine().split(" ");

        int[] colorsShirt = Arrays.stream(strColorsShirt)
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] colorsPants = Arrays.stream(strColorsPants)
                .mapToInt(Integer::parseInt)
                .toArray();

        int diff = Integer.MAX_VALUE;
        int shirtIdx = 0;
        int pantsIdx = 0;
        int i = 0;
        int j = 0;
        while (i <= colorsShirt.length - 1 && colorsShirt[i] < 0) {
            i++;
        }
        while (j <= colorsPants.length - 1 &&colorsPants[j] < 0) {
            j++;
        }
        while (i < colorsShirt.length && j < colorsPants.length) {
            int currentDiff = Math.abs(colorsShirt[i] - colorsPants[j]);
            if (currentDiff < diff) {
                diff = currentDiff;
                shirtIdx = i;
                pantsIdx = j;
            }
            if (colorsShirt[i] < colorsPants[j]) {
                i++;
            } else if (colorsShirt[i] > colorsPants[j]) {
                j++;
            } else {
                diff = currentDiff;
                shirtIdx = i;
                pantsIdx = j;
                break;
            }
        }
        System.out.println(colorsShirt[shirtIdx] + " " + colorsPants[pantsIdx]);
    }
}
