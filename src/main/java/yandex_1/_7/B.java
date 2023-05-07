package yandex_1._7;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        long start = 0;
        double duration;
        PrintWriter consoleOutput = new PrintWriter(System.out);
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        String[] str = strings.get(0).split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        strings.remove(0);

        Set<Segment> segments = new TreeSet<>();


        start = System.currentTimeMillis();
        duration = (System.currentTimeMillis() - start) / 1000.;
//        consoleOutput.println();
//        consoleOutput.println(sb.toString().trim());
        consoleOutput.println(duration);
        consoleOutput.flush();
        consoleOutput.close();
    }

    private static class Segment implements Comparable<Segment> {
        int left;
        int right;

        public Segment(int left, int right) {
            this.left = Math.min(left, right);
            this.right = Math.max(left, right);
        }

        public boolean containsPoint(int p) {
            return left <= p && p <= right;
        }

        @Override
        public String toString() {
            return "Segment{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }

        @Override
        public int compareTo(Segment s) {
            return compare(this, s);
        }

        private int compare(Segment s1, Segment s2) {
            if (s1.left <= s2.left) {
                return 1;
            }
            return -1;
        }
    }
}
