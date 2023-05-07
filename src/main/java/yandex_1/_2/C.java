package yandex_1._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        int target = Integer.parseInt(reader.readLine());

        int res = 0;
        int diff = Integer.MAX_VALUE;
        for (String s : str) {
            int i = Integer.parseInt(s);
            if (Math.abs(target - i) < diff) {
                diff = Math.abs(target - i);
                res = i;
            }
        }
        System.out.println(res);
    }
}
