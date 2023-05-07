package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class MyFirstArrayDeque {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String[] command;
//        MyDeque deque = new MyDeque();
//
//        Queue queue = new ArrayDeque();
//        String cmd;
//        do {
//            command = reader.readLine().split(" ");
//            cmd = command[0];
//            if (command.length < 2) {
//                switch (cmd) {
//                    case "pop_front" -> deque.pop_front();
//                    case "pop_back" -> deque.pop_back();
//                    case "front" -> deque.front();
//                    case "back" -> deque.back();
//                    case "size" -> deque.size();
//                    case "clear" -> deque.clear();
//                    case "exit" -> System.out.println("bye");
//                }
//            } else {
//                int value = Integer.parseInt(command[1]);
//                switch (cmd) {
//                    case "push_front" -> deque.push_front(value);
//                    case "push_back" -> deque.push_back(value);
//                }
//            }
//        } while (!cmd.equals("exit"));
//    }

    private static class MyDeque {
        int head;
        int tail;
        int size;
        int[] items;
        int capacity = 100_000;

        public MyDeque() {
            items = new int[capacity];
            head = items.length / 2;
            tail = items.length / 2;
            size = 0;
        }


        public void push_front(int element) {
            if (isEmpty()) {
                items[head] = element;
            } else {
                items[--head] = element;
            }
            size++;
            System.out.println("ok");
        }

        public void push_back(int element) {
            if (isEmpty()) {
                items[tail] = element;
            } else {
                items[++tail] = element;
            }
            size++;
            System.out.println("ok");
        }

        public void pop_front() {
            int element = 0;
            if (isEmpty()) {
                System.out.println("error");
            } else if (size == 1) {
                element = items[head];
                size--;
                System.out.println(element);
            } else {
                element = items[head++];
                size--;
                System.out.println(element);
            }
        }

        public void pop_back() {
            int element = 0;
            if (isEmpty()) {
                System.out.println("error");
            } else if (size == 1) {
                element = items[tail];
                size--;
                System.out.println(element);
            } else {
                element = items[tail--];
                size--;
                System.out.println(element);
            }
        }

        public void front() {
            if (isEmpty()) {
                System.out.println("error");
            } else {
                System.out.println(items[head]);
            }
        }

        public void back() {
            if (isEmpty()) {
                System.out.println("error");
            } else {
                System.out.println(items[tail]);
            }
        }

        public void size() {
            System.out.println(size);
        }

        public synchronized void clear() {
            items = new int[capacity];
            head = items.length / 2;
            tail = items.length / 2;
            size = 0;
            System.out.println("ok");
        }

        private boolean isEmpty() {
            return size == 0;
        }
    }
}
