package yandex_1._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int tRoom = Integer.parseInt(s[0]);
        int tCond = Integer.parseInt(s[1]);
        String com = reader.readLine();

//        int a = switch (com) {
//            case "freeze" -> Math.min(tRoom, tCond);
//            case "heat" -> Math.max(tRoom, tCond);
//            case "auto" -> tCond;
//            case "fan" -> tRoom;
//            default -> 0;
//        };
//
//        PrintWriter consoleOutput = new PrintWriter(System.out);
//        consoleOutput.println(a);
//        consoleOutput.flush();
//        consoleOutput.flush();
    }
}
