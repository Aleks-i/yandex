package code_run.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ManyChairs {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));

        int[] purchase = Arrays.stream(strings.get(1).split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int[] sales = Arrays.stream(strings.get(2).split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int i = 0;
        int j = sales.length - 1;
        long profit = 0;
        while (i != purchase.length && j != sales.length && purchase[i] < sales[j]) {
            profit += (sales[j] - purchase[i]);
            i++;
            j--;
        }
        System.out.println(profit);
    }
}
