package yandex_1._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String[] str = reader.readLine().split(" ");

        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(str[str.length - 1]) && isPalindrome(Arrays.copyOfRange(str, i, str.length))){
                break;
            }
            res.add(str[i]);
        }
        System.out.println(res.size());
        Collections.reverse(res);
        res.forEach(e -> System.out.print(e + " "));
    }

    private static boolean isPalindrome(String[] str) {
        int s = 0;
        int e = str.length - 1;
        while (s < e) {
            if (!str[s].equals(str[e])) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
