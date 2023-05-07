package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SNTP {
    public static void main(String[] args) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LocalTime timeA = converStringToTime(reader.readLine().split(":"));
        LocalTime timeB = converStringToTime(reader.readLine().split(":"));
        LocalTime timeC = converStringToTime(reader.readLine().split(":"));

        LocalTime serverDelay = getServerDelay(timeC, timeA);

        LocalTime resulTime = timeB.plusHours(serverDelay.getHour()).plusMinutes(serverDelay.getMinute()).plusSeconds(serverDelay.getSecond());

//        System.out.println(dtf.format(serverDelay));
        System.out.println(dtf.format(resulTime));
    }

    private static LocalTime converStringToTime(String[] str) {
        return LocalTime.of(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
    }

    private static LocalTime getServerDelay(LocalTime ltEnd, LocalTime ltStart) {
        LocalTime differencetTotal = ltEnd.minusHours(ltStart.getHour()).minusMinutes(ltStart.getMinute()).minusSeconds(ltStart.getSecond());
        differencetTotal = differencetTotal.getSecond() % 2 == 0 ? differencetTotal : differencetTotal.plusSeconds(1);
        return LocalTime.ofSecondOfDay(differencetTotal.toSecondOfDay() / 2);
    }
}
