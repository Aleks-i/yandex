package yandex_1._6;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class A {
    public static void main(String[] args) throws IOException {
        PrintWriter consoleOutput = new PrintWriter(System.out);
        long start;
        double duration;
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int[] str = Arrays.stream(strings.get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (str[0] == 0 || str[1] == 0) {
            consoleOutput.println("NO");
        } else {
            int[] arr1 = Arrays.stream(strings.get(1).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] arr2 = Arrays.stream(strings.get(2).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            start = System.currentTimeMillis();
            Arrays.sort(arr1);
            for (int j : arr2) {
                boolean isFind = false;
                int low = 0;
                int high = arr1.length - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (arr1[mid] == j) {
                        isFind = true;
                        break;
                    } else if (arr1[mid] < j) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                if (isFind) {
                    consoleOutput.println("YES");
                } else {
                    consoleOutput.println("NO");
                }
            }
            duration = (System.currentTimeMillis() - start) / 1000.;
//            consoleOutput.println(duration);
        }
        consoleOutput.flush();
        consoleOutput.close();
    }
}
