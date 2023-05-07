package yandex_2.B._1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class D {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int n = Integer.parseInt(strings.get(0));
        int[] coordinates = Arrays.stream(strings.get(1).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int shortWayIdx = coordinates[coordinates.length / 2];
        System.out.println(shortWayIdx);
    }
}
