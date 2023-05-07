package yandex_1._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr1 = getArr(reader.readLine().split(" "));
        int[] arr2 = getArr(reader.readLine().split(" "));

        int i = 0;
        int j = 0;
        Set<Integer> set = new TreeSet<>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                set.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        set.forEach(s -> System.out.print(s + " "));
    }

    private static int[] getArr(String[] s) {
        return Arrays.stream(s)
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }
}
