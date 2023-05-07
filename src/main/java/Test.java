import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class Test extends Thread{
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter(new File("input.txt"));

        BigInteger bigInteger1 = new BigInteger("49998").pow(3);
        BigInteger bigInteger2 = new BigInteger("49999").pow(3);
        BigInteger bigInteger3 = new BigInteger("50000").pow(3);
        System.out.println(bigInteger1.add(bigInteger2).add(bigInteger3));
        long a = 0;

        BigInteger res = new BigInteger(String.valueOf(0));
        for (int i = 1; i <= 49997; i++) {
            BigInteger mult = new BigInteger(String.valueOf(i)).pow(3);
            res = mult.add(res);
        }
        System.out.println(res);
        System.out.println(res.longValue());
////1562437500625000000
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(res);

//        LocalDateTime ltd = LocalDateTime.of(2020,5, 5, 13, 31, 0);
//        LocalDateTime ltd2 = LocalDateTime.of(2020,5, 5, 13, 30, 59);
//
//        System.out.println(ltd.isBefore(ltd2));
//        System.out.println(ltd.isAfter(ltd2));

//        writer.write("1000 1000 100000" + "\n");
//        for (int i = 0; i < 100_000; i++) {
//            writer.write("RESET 3" + "\n");
//        }
//        generateForPalletsStock(writer);
        writer.close();
    }

    private static void genSeq(int n){
        int num = 0;
        int min = 1;
        int max = ++n - min;
        for (int i = 0; i < 100; i++) {
                num = (int) (Math.random() * max) + min;
            System.out.println(num);
        }
    }

    private static void generateForPalletsStock(FileWriter writer) throws IOException {
        writer.write("300_001" + "\n");

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 300_000 + 1; i++) {

            long number = 0L;
            for (int j = 0; j < 2; j++) {
                while (number == 0) {
                    number = (long) (Math.random() * 1_000_000_000);
                }
                sb.append(number).append(" ");
                sb.trimToSize();
                number = 0;
            }
            writer.write(sb.append("\n").toString());
            sb.setLength(0);
        }
        writer.close();
    }
}
