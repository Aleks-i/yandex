package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class CorrectParenthesis {
//    public static final Map<Character, Character> brackets = Map.of('(', ')', '[', ']', '{', '}');
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        char[] val = reader.readLine().toCharArray();
//        Stack stack = new Stack();
//
//        for (Character ch : val) {
//            if (stack.isEmpty()) {
//                stack.push(ch);
//            } else if (brackets.containsKey(ch)) {
//                stack.push(ch);
//            } else if (stack.back() == getKeyForValue(ch)) {
//                stack.pop();
//            } else {
//                stack.push(ch);
//            }
//        }
//
//        if (stack.size() == 0) {
//            System.out.println("yes");
//        } else {
//            System.out.println("no");
//        }
//    }
//
//    private static char getKeyForValue(Character ch) {
//        for (Map.Entry<Character, Character> entry : brackets.entrySet()) {
//            if (entry.getValue() == ch) {
//                return entry.getKey();
//            }
//        }
//        return ' ';
//    }
//
//    static class Stack {
//        private int size;
//        private int elementCount;
//        private char[] stackArray;
//        private int top;
//
//        public Stack() {
//            stackArray = new char[100_000];
//            top = -1;
//            size = 0;
//        }
//
//        public synchronized void push(char element) {
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
//        public char back() {
//            if (size != 0) {
//                return stackArray[top];
//            }
//            return ' ';
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
//            stackArray = new char[100_000];
//            top = -1;
//            size = 0;
//        }
//    }
}
