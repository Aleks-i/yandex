package yandex_3_0_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class HistogramAndRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);

        Stack<Rectangle> stack = new Stack<>();
        long[] sqare = new long[n + 1];
        Rectangle stackRectangle;
        for (int i = 1; i <= n; i++) {
            Rectangle rectangle = new Rectangle(i, Long.parseLong(str[i]));
            if (stack.isEmpty()) {
                stack.push(rectangle);
            } else if (stack.peek().height > rectangle.height) {
                do {
                    stackRectangle = stack.pop();
                    sqare[stackRectangle.idx] = (rectangle.idx - stackRectangle.idx) * stackRectangle.height;
                } while (!stack.isEmpty() && stack.peek().height > rectangle.height);
                stack.push(rectangle);
            } else if (i == n) {
                sqare[i] = rectangle.height * (n + 1 - i);
                while (!stack.isEmpty()) {
                    stackRectangle = stack.pop();
                    sqare[stackRectangle.idx] = (n + 1 - stackRectangle.idx) * stackRectangle.height;
                }
            } else {
                stack.push(rectangle);
            }
        }

        for (int i = n; i > 0; i--) {
            Rectangle rectangle = new Rectangle(i, Integer.parseInt(str[i]));
            if (stack.isEmpty()) {
                stack.push(rectangle);
            } else if (stack.peek().height > rectangle.height) {
                do {
                    stackRectangle = stack.pop();
                    sqare[stackRectangle.idx] += (stackRectangle.idx - rectangle.idx - 1) * stackRectangle.height;
                } while (!stack.isEmpty() && stack.peek().height >= rectangle.height);
                stack.push(rectangle);
            } else {
                stack.push(rectangle);
            }
            if (!stack.isEmpty() && i == 1) {
                do {
                    stackRectangle = stack.pop();
                    sqare[stackRectangle.idx] += (stackRectangle.idx - 1) * stackRectangle.height;
                } while (!stack.isEmpty());
            }
        }
//        System.out.println(Arrays.toString(sqare));
        if (n == 1) {
            System.out.println(str[n]);
        } else {
            Arrays.sort(sqare);
            System.out.println(sqare[sqare.length - 1]);
        }
    }

    private static class Rectangle {
        int idx;
        long height;

        public Rectangle(int idx, long height) {
            this.height = height;
            this.idx = idx;
        }
    }
}
