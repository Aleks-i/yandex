package yandex_1._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int[] carsNumbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int countAccord = 0;
        int i = 0;
        int j = 1;
        int numbersSum = carsNumbers[j] + carsNumbers[i];
        while (i < carsNumbers.length && j < carsNumbers.length) {
            if (numbersSum < k) {
                j++;
                if (j < carsNumbers.length) {
                    numbersSum += carsNumbers[j];
                }
            } else if (numbersSum > k) {
                numbersSum -= carsNumbers[i];
                i++;
            } else {
                countAccord++;
                int idxJAtAccord = j + 1;
                while (idxJAtAccord < carsNumbers.length && carsNumbers[idxJAtAccord] == carsNumbers[idxJAtAccord - 1]) {
                    countAccord++;
                    idxJAtAccord++;
                }
                numbersSum -= carsNumbers[i];
                i++;
            }
        }
        System.out.println(countAccord);
    }
}
