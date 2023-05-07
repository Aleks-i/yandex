package code_run.back;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static code_run.back.Meetings.Test.*;

public class Meetings {
    private static final int YEAR = 2018;

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        PrintWriter consoleOutput = new PrintWriter(System.out);

        int n = Integer.parseInt(strings.get(0));

        LinkedHashMap<LocalDateTime, Meet> meetMap = new LinkedHashMap<>();
//        for (int i = 1; i < n + 1; i++) {
//            String res = getResult(strings.get(i).split(" "), meetMap);
//            if (!res.isEmpty()) {
//                consoleOutput.println(res);
//            }
//        }
//        tester(consoleOutput, test1, expectedT1);
//        tester(consoleOutput, test2, expectedT2);
//        tester(consoleOutput, test3, expectedT3);
        tester(consoleOutput, test4, expectedT4);
//        tester(consoleOutput, test5, expectedT5);
//        tester(consoleOutput, test6, expectedT6);
        tester(consoleOutput, test7, expectedT7);

        consoleOutput.flush();
        consoleOutput.close();
    }

    private static void tester(PrintWriter consoleOutput, List<String> test, String expected) {
        StringBuilder actual = new StringBuilder();
        int n = Integer.parseInt(test.get(0).split(" ")[0]);
        int testN = Integer.parseInt(test.get(0).split(" ")[1]);

        LinkedHashMap<LocalDateTime, Meet> meetMap = new LinkedHashMap<>();
        for (int i = 1; i < n + 1; i++) {
            String res = getResult(test.get(i).split(" "), meetMap);
            if (!res.isEmpty()) {
                actual.append(res).append("\n");
            }
        }
        if (!actual.toString().trim().equals(expected)) {
            consoleOutput.println("Test " + testN);
            consoleOutput.println("actual: \n" + actual);
            consoleOutput.println("expected: \n" + expected + "\n");
        } else {
            consoleOutput.println("Test " + testN);
            consoleOutput.println("Ok");
        }
        consoleOutput.flush();
    }

    private static String getResult(String[] str, LinkedHashMap<LocalDateTime, Meet> meetMap) {
        String command = str[0];
        switch (command) {
            case "APPOINT" -> {
                int day = Integer.parseInt(str[1]);
                String[] time = str[2].split(":");

                LocalDateTime dateTimeStart = parseDatTime(day, Integer.parseInt(time[0]), Integer.parseInt(time[1]));
                LocalDateTime dateTimeEnd = dateTimeStart.plusMinutes(Long.parseLong(str[3])).minusMinutes(1L);
                int k = Integer.parseInt(str[4]);

                List<String> nameList = new ArrayList<>(Arrays.asList(str).subList(5, str.length));
                Meet meet = new Meet(dateTimeStart, dateTimeEnd, k, nameList);

                String intersection = checkIntersections(meetMap, meet);
                if (intersection.isEmpty()) {
                    meetMap.put(dateTimeStart, meet);
                    return "OK";
                } else {
                    return intersection;
                }
            }
            case "PRINT" -> {
                return getEvent(meetMap, str);
            }
        }
        return "";
    }

    private static String getEvent(LinkedHashMap<LocalDateTime, Meet> meetMap, String[] event) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        LocalDate date = LocalDate.ofYearDay(YEAR, Integer.parseInt(event[1]));
        String name = event[2];
        StringBuilder sb = new StringBuilder();
        TreeMap<LocalDateTime, Meet> sortedMeetMap = new TreeMap<>(meetMap);
        for (Map.Entry<LocalDateTime, Meet> e : sortedMeetMap.entrySet()) {
            if (e.getKey().toLocalDate().equals(date)) {
                List<String> names = e.getValue().nameList;
                for (String n : names) {
                    if (n.equals(name)) {
                        sb.append(e.getKey().format(df)).append(" ")
                                .append(e.getValue().dateTimeEnd.minusMinutes(e.getKey().getMinute()).plusMinutes(1L).getMinute())
                                .append(" ");
                        for (String n1 : names) {
                            sb.append(n1).append(" ");
                        }
                        sb.deleteCharAt(sb.length() - 1).append("\n");
                    }
                }
            }
        }
        return sb.toString().trim();
    }

    private static String checkIntersections(LinkedHashMap<LocalDateTime, Meet> meetMap, Meet meet) {
        StringBuilder sb = new StringBuilder();
        for (String n1 : meet.nameList) {
            exit:
            for (Map.Entry<LocalDateTime, Meet> e : meetMap.entrySet()) {
                LocalDateTime ldtStartExisting = e.getKey();
                LocalDateTime ldtEndExisting = e.getValue().dateTimeEnd;
                LocalDateTime ldtStartCurr = meet.dateTimeStart;
                LocalDateTime ldtEndCurr = meet.dateTimeEnd;

                if (ldtEndCurr.isAfter(ldtStartExisting) && ldtStartCurr.isBefore(ldtEndExisting)
                        || ldtStartCurr.equals(ldtEndExisting) || ldtEndCurr.equals(ldtStartExisting)) {
                    List<String> nameListExist = e.getValue().nameList;
                    for (String n : nameListExist) {
                        if (n.equals(n1)) {
                            if (sb.toString().isEmpty()) {
                                sb.append("FAIL").append("\n");
                            }
                            sb.append(n).append(" ");
                            break exit;
                        }
                    }
                }
            }
        }
        return sb.toString().trim();
    }

    private static LocalDateTime parseDatTime(int d, int h, int m) {
        LocalDate date = LocalDate.ofYearDay(YEAR, d);
        return LocalDateTime.of(YEAR, date.getMonth(), date.getDayOfMonth(), h, m);
    }

    private static class Meet {
        LocalDateTime dateTimeStart;
        LocalDateTime dateTimeEnd;
        int k;
        List<String> nameList;

        public Meet(LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd, int k, List<String> nameList) {
            this.dateTimeStart = dateTimeStart;
            this.dateTimeEnd = dateTimeEnd;
            this.k = k;
            this.nameList = nameList;
        }
    }

    static class Test {

        //test1
        static List<String> test1 = List.of("7 1",
                "APPOINT 1 12:30 30 2 andrey alex",
                "APPOINT 1 12:00 30 2 alex sergey",
                "APPOINT 1 12:59 60 2 alex andrey",
                "PRINT 1 alex",
                "PRINT 1 andrey",
                "PRINT 1 sergey",
                "PRINT 2 alex");

        static String expectedT1 = "OK\n" +
                "OK\n" +
                "FAIL\n" +
                "alex andrey\n" +
                "12:00 30 alex sergey\n" +
                "12:30 30 andrey alex\n" +
                "12:30 30 andrey alex\n" +
                "12:00 30 alex sergey";
        //test2
        static List<String> test2 = List.of("2 2",
                "APPOINT 1 12:30 30 4 andrey alex sergey nikolay\n",
                "APPOINT 1 12:45 30 2 alex sergey");
        static String expectedT2 = "OK\n" +
                "FAIL\n" +
                "alex sergey";

        //test3
        static List<String> test3 = List.of("3 3",
                "APPOINT 15 13:30 30 2 andrey alex",
                "APPOINT 15 12:00 30 3 vlad sergey andrey",
                "APPOINT 15 12:29 30 2 alex vlad");

        static String expectedT3 = "OK\n" +
                "OK\n" +
                "FAIL\n" +
                "vlad";

        //test4
        static List<String> test4 = List.of("9 4",
                "APPOINT 15 12:29 30 3 andrey alex mih", //ok
                "APPOINT 15 12:30 30 3 vlad sergey mih", //fail
                "APPOINT 15 12:00 31 2 mih alex", //fail
                "PRINT 15 mih",
                "APPOINT 15 14:30 30 3 nik art mih", //ok
                "PRINT 15 mih",
                "APPOINT 15 10:30 30 4 nik art mih mar",
                "PRINT 15 mih",
                "APPOINT 15 10:30 120 6 nik mih mar andrey art alex");

        static String expectedT4 = "OK\n" +
                "FAIL\n" +
                "mih\n" +
                "FAIL\n" +
                "mih alex\n" +
                "12:29 30 andrey alex mih\n" +
                "OK\n" +
                "12:29 30 andrey alex mih\n" +
                "14:30 30 nik art mih\n" +
                "OK\n" +
                "10:30 30 nik art mih mar\n" +
                "12:29 30 andrey alex mih\n" +
                "14:30 30 nik art mih\n" +
                "FAIL\n" +
                "nik mih mar andrey art alex";

        //test5
        static List<String> test5 = List.of("9 5",
                "APPOINT 45 12:00 30 2 andrey alex", //ok
                "APPOINT 45 11:59 1 2 andrey alex", //ok
                "APPOINT 45 11:57 2 2 andrey alex", //ok
                "APPOINT 45 12:30 1 2 andrey alex", //ok
                "APPOINT 45 12:31 30 2 andrey alex", //ok
                "APPOINT 45 11:30 31 2 andrey alex", //fail
                "APPOINT 45 11:29 32 2 andrey alex", //fail
                "APPOINT 45 12:29 32 2 andrey alex", //fail
                "APPOINT 45 12:28 32 2 andrey alex" //fail
        );
        static String expectedT5 = "OK\n" +
                "OK\n" +
                "OK\n" +
                "OK\n" +
                "OK\n" +
                "FAIL\n" +
                "andrey alex\n" +
                "FAIL\n" +
                "andrey alex\n" +
                "FAIL\n" +
                "andrey alex\n" +
                "FAIL\n" +
                "andrey alex";

        //test6
        static List<String> test6 = List.of("11 6",
                "APPOINT 15 12:30 30 3 andrey alex mih", //ok
                "APPOINT 15 11:30 30 3 vlad sergey mih", //ok
                "APPOINT 15 13:00 30 3 mih alex nat", //ok
                "APPOINT 15 19:30 30 3 nik art mih", //ok
                "APPOINT 15 14:30 30 4 nik art mih mar", //ok
                "PRINT 15 mar",
                "APPOINT 15 10:29 2 6 nik mih mar andrey art alex", //ok
                "PRINT 15 alex",
                "PRINT 14 alexcc",
                "PRINT 15 mih",
                "PRINT 15 mar"
        );

        static String expectedT6 = "OK\n" +
                "OK\n" +
                "OK\n" +
                "OK\n" +
                "OK\n" +
                "14:30 30 nik art mih mar\n" +
                "OK\n" +
                "10:29 2 nik mih mar andrey art alex\n" +
                "12:30 30 andrey alex mih\n" +
                "13:00 30 mih alex nat\n" +
                "10:29 2 nik mih mar andrey art alex\n" +
                "11:30 30 vlad sergey mih\n" +
                "12:30 30 andrey alex mih\n" +
                "13:00 30 mih alex nat\n" +
                "14:30 30 nik art mih mar\n" +
                "19:30 30 nik art mih\n" +
                "10:29 2 nik mih mar andrey art alex\n" +
                "14:30 30 nik art mih mar";

        //test 7
        static List<String> test7 = List.of("2 7",
                "APPOINT 15 12:59 30 3 andrey alex mih", //ok
                "APPOINT 15 11:00 120 6 nik mih mar andrey art alex");

        static String expectedT7 = "OK\n" +
                "FAIL\n" +
                "mih andrey alex";
    }
}
