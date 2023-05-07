package yandex_1._1;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class E {
    public static void main(String[] args) throws IOException {
        PrintWriter consoleOutput = new PrintWriter(System.out);
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        String[] s = strings.get(0).split(" ");
        int k1 = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k2 = Integer.parseInt(s[2]);
        int p2 = Integer.parseInt(s[3]);
        int n2 = Integer.parseInt(s[4]);

        double numberFloor = (p2 - 1) * m + n2;
        double countApartmentAtFloor = Math.ceil(k2 / numberFloor);

        int floorAppartmentCommon = (int) Math.ceil(k1 / countApartmentAtFloor);
        int entrance = (int) Math.ceil(k1 / (m * countApartmentAtFloor));
        int floorAppartmentTarget = floorAppartmentCommon - (entrance - 1) * m;

        if (n2 > m) {
            consoleOutput.println(-1 + " " + -1);
        } else if (k2 < numberFloor) {
            consoleOutput.println(-1 + " " + -1);
        } else if (k1 == k2) {
            consoleOutput.println(p2 + " " + n2);
        } else if (numberFloor == 1) {
            if (m == 1) {
                consoleOutput.println(0 + " " + 1);
            } else if (m > k1) {
                consoleOutput.println(1 + " " + 0);
            } else if (k1 < k2 && p2 == 1) {
                consoleOutput.println(1 + " " + 1);
            } else if (k1 < k2) {
                consoleOutput.println(0 + " " + 1);
            } else {
                consoleOutput.println(0 + " " + 0);
            }
        } else if (((numberFloor - 1) * (countApartmentAtFloor + 1) < k2)
                || (numberFloor + 1) * (countApartmentAtFloor - 1) - (countApartmentAtFloor - 1) + 1 > k2) {
            double countApartmentAtFloor1 = countApartmentAtFloor + 1;
            int floorAppartmentCommon1 = (int) Math.ceil(k1 / countApartmentAtFloor1);
            int entrance1 = (int) Math.ceil(k1 / (m * countApartmentAtFloor1));
            int floorAppartmentTarget1 = floorAppartmentCommon1 - (entrance1 - 1) * m;
            if (floorAppartmentTarget1 == floorAppartmentTarget) {
                consoleOutput.println(0 + " " + floorAppartmentTarget);
            }
        } else {
            consoleOutput.println(entrance + " " + floorAppartmentTarget);
        }

        consoleOutput.flush();
        consoleOutput.close();
    }
}
