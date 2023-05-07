package yandex_1._3;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringList = Files.readAllLines(Paths.get("input.txt"));
        String[] str = stringList.get(0).split(" ");

        long start;
        double duration;
        PrintWriter consoleOutput = new PrintWriter(System.out);
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        start = System.currentTimeMillis();
        Set<Integer> annaCubes = getCubes(1, n + 1, stringList);
        Set<Integer> borisCubes = getCubes(n + 1, m + n + 1, stringList);
        duration = (System.currentTimeMillis() - start) / 1000.;

        Set<Integer> accordCubes = new TreeSet<>();
        Iterator<Integer> aCIterator = annaCubes.iterator();
        while (aCIterator.hasNext()){
            int aC = aCIterator.next();
            if (borisCubes.contains(aC)) {
                accordCubes.add(aC);
                borisCubes.remove(aC);
                aCIterator.remove();
            }
        }

        consoleOutput.println(accordCubes.size());
        accordCubes.forEach(ac -> consoleOutput.print(ac + " "));
        consoleOutput.println();
        consoleOutput.println(annaCubes.size());
        annaCubes.forEach(an -> consoleOutput.print(an + " "));
        consoleOutput.println();
        consoleOutput.println(borisCubes.size());
        borisCubes.forEach(bc -> consoleOutput.print(bc + " "));

        consoleOutput.println();
        consoleOutput.println();
        consoleOutput.println(duration);

        consoleOutput.flush();
        consoleOutput.close();
    }

    private static Set<Integer> getCubes(int start, int end, List<String> stringList) throws IOException {
        Set<Integer> set = new TreeSet<>();
        for (int i = start; i < end; i++) {
            set.add(Integer.parseInt(stringList.get(i)));
        }
        return set;
    }
}
