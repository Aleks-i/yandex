package code_run.back;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class DayWeek {
    public static void main(String[] args) throws IOException {
//        long startTime = System.nanoTime();
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        PrintWriter consoleOutput = new PrintWriter(System.out);
//        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
//
//        String line;
//        String[] str;
//        int m;
//        GregorianCalendar calendar;
//        SimpleDateFormat df = new SimpleDateFormat("EEEE", Locale.ENGLISH);
//        while ((line = reader.readLine()) != null) {
//            str = line.split(" ");
//            m = getMonth(str[1].toUpperCase());
//
//            calendar = new GregorianCalendar(Integer.parseInt(str[2]), m, Integer.parseInt(str[0]));
//            consoleOutput.println(df.format(calendar.getTime()));
//        }

        SimpleDateFormat df = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        String[] str;
        GregorianCalendar calendar;
        int m;
        for (String s : strings){
            str = s.split(" ");
            m = getMonth(str[1].toUpperCase());

            calendar = new GregorianCalendar(Integer.parseInt(str[2]), m, Integer.parseInt(str[0]));
            consoleOutput.println(df.format(calendar.getTime()));
        }


        consoleOutput.flush();
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime) / 1000000;
//        consoleOutput.println(duration);
//        consoleOutput.flush();
        consoleOutput.close();

    }

    private static int getMonth(String str) {
        switch (str) {
            case "JANUARY" -> {
                return Calendar.JANUARY;
            }
            case "FEBRUARY" -> {
                return Calendar.FEBRUARY;
            }
            case "MARCH" -> {
                return Calendar.MARCH;
            }
            case "APRIL" -> {
                return Calendar.APRIL;
            }
            case "MAY" -> {
                return Calendar.MAY;
            }
            case "JUNE" -> {
                return Calendar.JUNE;
            }
            case "JULY" -> {
                return Calendar.JULY;
            }
            case "AUGUST" -> {
                return Calendar.AUGUST;
            }
            case "SEPTEMBER" -> {
                return Calendar.SEPTEMBER;
            }
            case "OCTOBER" -> {
                return Calendar.OCTOBER;
            }
            case "NOVEMBER" -> {
                return Calendar.NOVEMBER;
            }
            case "DECEMBER" -> {
                return Calendar.DECEMBER;
            }
        }
        return -1;
    }
}
