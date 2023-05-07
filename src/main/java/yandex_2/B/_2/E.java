package yandex_2.B._2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class E {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int[] diplomas = Arrays.stream(strings.get(1).split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int time = 0;
        for (int i = 0; i < diplomas.length - 1; i++) {
            time += diplomas[i];
        }
        System.out.println(time);
    }
}
