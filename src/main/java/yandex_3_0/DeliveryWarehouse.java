package yandex_3_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class DeliveryWarehouse {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i =0; i < n; i++) {
            String[] str = reader.readLine().split(" ");
            if (Integer.parseInt(str[0]) == 0 && Integer.parseInt(str[1]) != 0) {
                stack.push(2);
            } else if (Integer.parseInt(str[0]) != 0 && Integer.parseInt(str[1]) == 0) {
                stack.push(1);
            } else if (Integer.parseInt(str[0]) > Integer.parseInt(str[1])) {
                stack.push(2);
            } else if (Integer.parseInt(str[0]) < Integer.parseInt(str[1])) {
                stack.push(1);
            } else if (Integer.parseInt(str[0]) != 0) {
                stack.push(1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
