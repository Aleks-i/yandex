package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodString {
    public static void main(String[] args) throws IOException {
        long goodString = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] countSymbols = new int[n];
        for (int i = 0; i <= countSymbols.length - 1; i++) {
            countSymbols[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < countSymbols.length - 1; i++) {
            int count = Math.min(countSymbols[i], countSymbols[i + 1]);
            goodString += count;
        }
        System.out.println(goodString);
    }
}
