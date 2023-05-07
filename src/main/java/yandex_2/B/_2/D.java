package yandex_2.B._2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class D {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int[] banch = Arrays.stream(strings.get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] coordinates = Arrays.stream(strings.get(1).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] cubes = new int[banch[0]];
        IntStream.range(0, banch[1]).forEach(i -> {
            cubes[coordinates[i]] = 1;
        });

        if (cubes.length % 2 != 0 && cubes[cubes.length / 2] == 1) {
            System.out.println(cubes.length / 2);
        } else {
            int idxLeft = cubes.length / 2 - 1;
            int idxRight = idxLeft + 1;

            while (cubes[idxLeft] != 1) {
                idxLeft--;
            }
            while (cubes[idxRight] != 1) {
                idxRight++;
            }
            System.out.println(idxLeft + " " + idxRight);
        }

    }
}
