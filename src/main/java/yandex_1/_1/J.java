package yandex_1._1;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.List;

public class J {
    public static void main(String[] args) throws IOException {
        PrintWriter consoleOutput = new PrintWriter(System.out);
        DecimalFormat format = new DecimalFormat("#.######");
        format.setDecimalSeparatorAlwaysShown(false);
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        double a = Double.parseDouble(strings.get(0));
        double b = Double.parseDouble(strings.get(1));
        double c = Double.parseDouble(strings.get(2));
        double d = Double.parseDouble(strings.get(3));
        double e = Double.parseDouble(strings.get(4));
        double f = Double.parseDouble(strings.get(5));

        double x;
        double y;
        if (a * d - b * c == 0) {
            if (a == 0 && c == 0 && b == 0 && d == 0 && e == 0 && f == 0) {
                consoleOutput.println(5);
            } else if (a + b == 0 && c + d == 0 && e == 0 && f == 0) {
                if (b < 0) {
                    consoleOutput.println(1 + " " + format.format(-a / b) + " " + format.format(e / b));
                } else {
                    consoleOutput.println(1 + " " + format.format(-c / d) + " " + format.format(f / d));
                }
            } else if (a == 0 && b == 0 && c == 0 && d == 0 && e != f) {
                consoleOutput.println(0);
            } else if (a / c == b / d && b / d != e / f) {
                consoleOutput.println(0);
            } else if (a == 0 && c == 0) {
                if (e / b == f / d || b == 0) {
                    y = (f / d);
                    consoleOutput.println(4 + " " + format.format(y));
                } else if (e / b == f / d || d == 0) {
                    y = (e / b);
                    consoleOutput.println(4 + " " + format.format(y));
                } else {
                    consoleOutput.println(0);
                }
            } else if (b == 0 && d == 0) {
                if (e / a == f / c || c == 0) {
                    x = e / a;
                    consoleOutput.print(3 + " " + format.format(x));
                } else if (e / a == f / c || a == 0) {
                    x = f / c;
                    consoleOutput.print(3 + " " + format.format(x));
                } else {
                    consoleOutput.println(0);
                }
            } else if (a / c == b / d && b / d == e / f) {
                if (b != 0) {
                    consoleOutput.println(1 + " " + format.format(-a / b) + " " + format.format(e / b));
                } else if (d != 0) {
                    consoleOutput.println(1 + " " + format.format(-c / d) + " " + format.format(f / d));
                } else {
                    consoleOutput.println(5);
                }
            }
        } else {
            x = (e * d - b * f) / (a * d - b * c);
            y = (f * a - c * e) / (d * a - b * c);
            consoleOutput.println(2 + " " + format.format(x) + " " + format.format(y));
        }
        consoleOutput.flush();
        consoleOutput.close();
    }
}
