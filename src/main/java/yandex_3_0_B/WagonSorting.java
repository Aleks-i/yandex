package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WagonSorting {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");

        int[] wagonsNumer = new int[n];
        for (int i = 0; i < n; i++) {
            wagonsNumer[i] = Integer.parseInt(str[i]);
        }

        Stack stack = new Stack();
        List<Integer> wagonsSort = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int wN = wagonsNumer[i];
            if (i == 0) {
                stack.push(wN);
            } else if (!stack.isEmpty() && stack.back() < wN) {
                while (!stack.isEmpty() && wN > stack.back()) {
                    wagonsSort.add(stack.back());
                    stack.pop();
                }
                stack.push(wN);
            } else if (!stack.isEmpty() && stack.back() > wN) {
                stack.push(wN);
            }
        }
        while (!stack.isEmpty()){
            wagonsSort.add(stack.pop());
        }
        String result = "YES";
        if (!wagonsSort.stream().sorted().collect(Collectors.toList()).equals(wagonsSort)) {
            result = "NO";
        }
        System.out.println(result);
    }

    static class Stack {
        private int size;
        private int elementCount;
        private int[] stackArray;
        private int top;

        public Stack() {
            stackArray = new int[100];
            top = -1;
            size = 0;
        }

        public synchronized void push(int element) {
            elementCount++;
            top++;
            stackArray[top] = element;
            size++;
        }

        public synchronized int pop() {
            int stackElement = stackArray[top];
            elementCount--;
            size--;
            top--;
            return stackElement;
        }

        public int back() {
            return stackArray[top];
        }

        public int size() {
            return size;
        }

        public synchronized void clear() {
            stackArray = new int[100];
            top = -1;
            size = 0;
        }

        public synchronized boolean isEmpty() {
            return size == 0;
        }
    }
}
