package yandex_1._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class I {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        char[][] field = new char[n + 2][m + 2];

        Arrays.stream(field).forEach(a -> Arrays.fill(a, '0'));
        for (int i = 0; i < k; i++) {
            s = reader.readLine().split(" ");
            field[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = '*';
        }

        int[] neighboursmatrixXY = new int[]{-1, -1, -1, 0, -1, 1, 0, -1, 0, 1, 1, -1, 1, 0, 1, 1};
        for (int j = 1; j < n + 1; j++) {
            for (int i = 1; i < m + 1; i++) {
                if (field[j][i] != '*') {
                    int countMine = 0;
                    for (int f = 0; f < neighboursmatrixXY.length - 1; f++) {
                        if (field[j + neighboursmatrixXY[f]][i + neighboursmatrixXY[f + 1]] == '*') {
                            countMine++;
                        }
                        f++;
                    }
                    field[j][i] = Character.forDigit(countMine, 10);
                }
            }
        }

        printMatrix(field);
    }

    private static void printMatrix(char[][] arr) {
        for (int j =1; j <= arr.length - 2; j++) {
            for (int i = 1; i <= arr[0].length - 2; i++) {
                if (i == 1) {
                    System.out.print(arr[j][i]);
                } else {
                    System.out.printf("%2s", arr[j][i]);
                }
            }
            System.out.println();
        }
    }
}
