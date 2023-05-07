package yandex_2.B._3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        Set<String> coincidence = new HashSet<>();
        Arrays.stream(strings.get(0).split( " ")).forEach(e -> {
            if (coincidence.contains(e)) {
                System.out.println("YES");
            } else {
                coincidence.add(e);
                System.out.println("NO");
            }
        });
    }
}
