package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostfixRecord {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String[] val = reader.readLine().trim().split(" ");
//        Stack stack = new Stack();
//
//        for (String str : val) {
//            if (stack.isEmpty()) {
//                stack.push(Integer.parseInt(str));
//            } else if (!isInteger(str)){
//                int a = stack.back();
//                stack.pop();
//                int b = stack.back();
//                stack.pop();
//                int result = calculate(a, b, str);
//                stack.push(result);
//            } else {
//                stack.push(Integer.parseInt(str));
//            }
//        }
//        System.out.println(stack.back());
//    }
//
//    private static int calculate(int a, int b, String str) {
//        return switch (str) {
//            case "+" -> a + b;
//            case "*" -> a * b;
//            case "/" -> b / a;
//            case "-" -> b - a;
//            default -> 0;
//        };
//    }
//
//    private static boolean isInteger(String str) {
//        try {
//            Integer.parseInt(String.valueOf(str));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    static class Stack {
//        private int size;
//        private int elementCount;
//        private int[] stackArray;
//        private int top;
//
//        public Stack() {
//            stackArray = new int[100_000];
//            top = -1;
//            size = 0;
//        }
//
//        public synchronized void push(int element) {
//            elementCount++;
//            top++;
//            stackArray[top] = element;
//            size++;
//        }
//
//        public synchronized void pop() {
//            if (size != 0) {
//                elementCount--;
//                size--;
//                top--;
//            }
//        }
//
//        public int back() {
//            if (size != 0) {
//                return stackArray[top];
//            }
//            return 0;
//        }
//
//        public int size() {
//            return size;
//        }
//
//        public boolean isEmpty() {
//            return size == 0;
//        }
//
//        public synchronized void clear() {
//            stackArray = new int[100_000];
//            top = -1;
//            size = 0;
//        }
//    }
}
