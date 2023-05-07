package yandex_1._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        Set<Integer> activeNumbers = Arrays.stream(str)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        Set<Integer> res = new HashSet<>();
        int num = Integer.parseInt(reader.readLine());
//        char[] num = reader.readLine().toCharArray();
//        for (Character ch : num) {
//            int n = Integer.parseInt(String.valueOf(ch));
//            if (!activeNumbers.contains(n)) {
//                res.add(n);
//            }
//        }

        while (num > 0) {
            int n = num % 10;
            if (!activeNumbers.contains(n)) {
                res.add(n);
            }
            num /= 10;
        }

        System.out.println(res.size());
    }
}
