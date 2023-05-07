package code_run.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class BeachProgrammer {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));

        for (int i = 2; i < strings.size(); i = i + 2) {
            long[] elements = Arrays.stream(strings.get(i).split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            System.out.println(getMinSimilarity(elements));
        }

//        for (int i = 0; i <= 10; i++) {
//            for (int j = 0; j <= 10; j++) {
//                System.out.print( i + " " + j + " XOR " + (i ^ j) + " | ");
//            }
//            System.out.println();
//        }
    }

    private static long getMinSimilarity(long[] elements) {
        long minSimilarity = Long.MAX_VALUE;
        Arrays.sort(elements);
        for (int i = 1; i < elements.length; i++) {
            minSimilarity = Math.min(elements[i - 1] ^ elements[i], minSimilarity);
        }
        return minSimilarity;
    }
}
