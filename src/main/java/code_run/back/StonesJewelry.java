package code_run.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StonesJewelry {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        Set<String> j = Arrays.stream(strings.get(0).split("")).collect(Collectors.toCollection(HashSet::new));
        String[] s = strings.get(1).split("");

        long count = Arrays.stream(s)
                .filter(st -> st.matches("\\w+"))
                .filter(j::contains)
                .count();

        System.out.println(count);
    }
}
