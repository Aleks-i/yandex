package code_run.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Error {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        strings.remove(0);

        int[] data = new int[strings.size()];
        int[] arr;
        int sum = 0;
        for (int i = 0; i < strings.size(); i++) {
            arr = Arrays.stream(strings.get(i).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int p = arr[0] * arr[1];
            sum += p;
            data[i] = p;
        }
        for (int i : data) {
            System.out.printf("%.12f\n", (double) i / sum);
        }
    }
}
