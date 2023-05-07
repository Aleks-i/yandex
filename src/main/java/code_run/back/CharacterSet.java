package code_run.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CharacterSet {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        String[] s = strings.get(0).split("");
        String[] c = strings.get(1).split("");
    }
}
