package yandex_1._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal a = new BigDecimal(reader.readLine());
        BigDecimal b = new BigDecimal(reader.readLine());
        BigDecimal c = new BigDecimal(reader.readLine());

        if (c.compareTo(new BigDecimal("0")) < 0) {
            System.out.println("NO SOLUTION");
        } else {
            if (a.compareTo(new BigDecimal("0")) == 0) {
                if (c.multiply(c).compareTo(b) == 0) {
                    System.out.println("MANY SOLUTIONS");
                } else {
                    System.out.println("NO SOLUTION");
                }
            } else if (a.multiply(c.multiply(c).subtract(b).divide(a)).add(b).compareTo(new BigDecimal("0")) < 0) {
                System.out.println("NO SOLUTION");
            } else if (c.multiply(c).subtract(b).divide(a).doubleValue() % 1 != 0) {
                System.out.println("NO SOLUTION");
            } else {
                System.out.println(c.multiply(c).subtract(b).divide(a));
            }
        }
    }
}
