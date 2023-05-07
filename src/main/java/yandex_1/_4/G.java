package yandex_1._4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class G {
    private static final Map<String, Long> storage = new HashMap<>();

//    public static void main(String[] args) throws IOException {
//        long start;
//        double duration;
//
////        start = System.currentTimeMillis();
//        List<String> stringList = Files.readAllLines(Paths.get("input.txt"));
////        PrintWriter consoleOutput = new PrintWriter(System.out);
//        stringList.forEach(str -> {
//            String[] s = str.split(" ");
//            String command = s[0];
//            long moneyAmount;
//            switch (command) {
//                case "DEPOSIT" -> {
//                    moneyAmount = Long.parseLong(s[2]);
//                    storage.merge(s[1], moneyAmount, (o, v) -> o + moneyAmount);
//                }
//                case "WITHDRAW" -> {
//                    moneyAmount = Long.parseLong(s[2]);
//                    storage.merge(s[1], -moneyAmount, (o, v) -> o - moneyAmount);
//                }
//                case "BALANCE" -> {
//                    String name = s[1];
//                    String res = storage.containsKey(name) ? String.valueOf(storage.get(name)) : "ERROR";
//                    System.out.println(res);
//                }
//                case "TRANSFER" -> {
//                    String nameOutput = s[1];
//                    String nameInput = s[2];
//                    moneyAmount = Long.parseLong(s[3]);
//                    storage.putIfAbsent(nameInput, 0L);
//                    storage.putIfAbsent(nameOutput, 0L);
//                    storage.compute(nameOutput, (k, v) -> v - moneyAmount);
//                    storage.compute(nameInput, (k, v) -> v + moneyAmount);
//                }
//                case "INCOME" -> {
//                    int percent = Integer.parseInt(s[1]);
//                    storage.forEach((key, value) -> {
//                        if (value > 0) {
//                            storage.compute(key, (k, v) -> v * (100 + percent) / 100);
//                        }
//                    });
//                }
//            }
//        });
//    }
}
