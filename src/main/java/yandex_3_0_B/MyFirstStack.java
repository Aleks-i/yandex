package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyFirstStack {

//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String[] command = new String[2];
//        Stack stack = new Stack();
//
//        do {
//            command = reader.readLine().split(" ");
//            switch (command[0]) {
//                case "push" -> {
//                    if (command.length < 2) {
//                        break;
//                    }
//                    stack.push(Integer.parseInt(command[1]));
//                }
//                case "pop" -> stack.pop();
//                case "back" -> stack.back();
//                case "size" -> stack.size();
//                case "clear" -> stack.clear();
//                case "exit" -> System.out.println("bye");
//            }
//        } while (!command[0].equals("exit"));
//    }
//
//    static class Stack {
//        private int size;
//        private int elementCount;
//        private int[] stackArray;
//        private int top;
//
//        public Stack() {
//            stackArray = new int[160000];
//            top = -1;
//            size = 0;
//        }
//
//        public synchronized void push(int element) {
//            elementCount++;
//            top++;
//            stackArray[top] = element;
//            size++;
//            System.out.println("ok");
//        }
//
//        public synchronized void pop() {
//            if (size == 0) {
//                System.out.println("error");
//            } else {
//                System.out.println(stackArray[top]);
//                elementCount--;
//                size--;
//                top--;
//            }
//        }
//
//        public void back() {
//            if (size == 0) {
//                System.out.println("error");
//            } else {
//                System.out.println(stackArray[top]);
//            }
//        }
//
//        public void size() {
//            System.out.println(size);
//        }
//
//        public synchronized void clear() {
//            stackArray = new int[160000];
//            top = -1;
//            size = 0;
//            System.out.println("ok");
//        }
//    }
}
