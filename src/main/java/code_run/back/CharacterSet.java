package code_run.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CharacterSet {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        String[] s = strings.get(0).split("");
        Set<String> c = Arrays.stream(strings.get(1).split("")).collect(Collectors.toSet());

        int res = 0;
        int count;
        for (int i = 0; i < s.length; i++) {
            count = getCountSymbols(i, s, c);
            if (count != 0 && res != 0) {
                res = Math.min(count, res);
            } else {
                res = Math.max(count, res);
            }
        }
        System.out.println(res);
    }

    private static int getCountSymbols(int startIdx, String[] s, Set<String> set) {
        int count = 0;
        Set<String> controlSet = new HashSet<>();
        for (int i = startIdx; i < s.length; i++) {
            String symbol = s[i];
            if (set.contains(symbol)) {
                controlSet.add(symbol);
                count++;
                if (controlSet.size() == set.size()) {
                    return count;
                }
            } else {
             return 0;
            }
        }
        return 0;
    }
}
