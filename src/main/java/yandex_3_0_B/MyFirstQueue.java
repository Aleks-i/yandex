package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyFirstQueue {

//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String[] command = new String[2];
//        MyQueue queue = new MyQueue();
//
//        do {
//            command = reader.readLine().split(" ");
//            switch (command[0]) {
//                case "push" -> {
//                    if (command.length < 2) {
//                        break;
//                    }
//                    queue.push(Integer.parseInt(command[1]));
//                }
//                case "pop" -> queue.pop();
//                case "front" -> queue.front();
//                case "size" -> queue.size();
//                case "clear" -> queue.clear();
//                case "exit" -> System.out.println("bye");
//            }
//        } while (!command[0].equals("exit"));
//    }

    private static class MyQueue {
        int[] items;
        int front = -1;
        int back = -1;

        public MyQueue() {
            this.items = new int[100000];
        }

        public void push(int n) {
            if (front == -1 && back == -1) {
                front = back = 0;
                items[back] = n;
            } else {
                back++;
                items[back] = n;
            }
            System.out.println("ok");
        }

        public void pop() {
            if (isEmpty()) {
                System.out.println("error");
            } else {
                int element = items[front];
                if (front == back) {
                    front = back = -1;
                } else {
                    front++;
                }
                System.out.println(element);
            }
        }

        public void front() {
            if (isEmpty()) {
                System.out.println("error");
            } else {
                System.out.println(items[front]);
            }
        }

        private boolean isEmpty() {
            return back == -1 && front == -1;
        }

        public void size() {
            if (back == -1 && front == -1) {
                System.out.println(0);
            } else {
                System.out.println(back - front + 1);
            }
        }

        public void clear() {
            back = -1;
            front = -1;
            items = new int[100000];
            System.out.println("ok");
        }
    }
}
