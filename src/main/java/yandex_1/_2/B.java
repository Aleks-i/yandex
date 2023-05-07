package yandex_1._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());


        boolean CONSTANT = true;
        boolean ASCENDING = true;
        boolean WEAKLY_ASCENDING = true;
        boolean DESCENDING = true;
        boolean WEAKLY_DESCENDING = true;

        Integer prev = null;
        while (i != -2_000_000_000) {
            if (prev != null) {
                if (i != prev) {
                    CONSTANT = false;
                }
                if (i <= prev) {
                    ASCENDING = false;
                }
                if (i < prev) {
                    WEAKLY_ASCENDING = false;
                }
                if (i >= prev) {
                    DESCENDING = false;
                }
                if (i > prev) {
                    WEAKLY_DESCENDING = false;
                }
            }
            prev = i;
            i = Integer.parseInt(reader.readLine());
        }

        if (CONSTANT) {
            System.out.println("CONSTANT");
        } else if (ASCENDING) {
            System.out.println("ASCENDING");
        } else if (WEAKLY_ASCENDING) {
            System.out.println("WEAKLY ASCENDING");
        } else if (DESCENDING) {
            System.out.println("DESCENDING");
        } else if (WEAKLY_DESCENDING) {
            System.out.println("WEAKLY DESCENDING");
        } else {
            System.out.println("RANDOM");
        }
    }
}
