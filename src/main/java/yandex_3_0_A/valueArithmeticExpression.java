package yandex_3_0_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class valueArithmeticExpression {
//    private static final int OPERAND_PRIORITY_1 = 1;
//    private static final int OPERAND_PRIORITY_2 = 2;
//    private static final Map<String, Integer> OPERAND_PRIORITY = Map.of(
//            "+", OPERAND_PRIORITY_1,
//            "-", OPERAND_PRIORITY_1,
//            "*", OPERAND_PRIORITY_2,
//            "/", OPERAND_PRIORITY_2);
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String[] normalizeString = normalizeString(reader.readLine().trim().toCharArray());
//        String[] postfixExpression;
//        Integer result;
//
//        if (normalizeString == null) {
//            System.out.println("WRONG");
//        } else if ((postfixExpression = getPostfixExpression(normalizeString)) == null) {
//            System.out.println("WRONG");
//        } else if ((result = postfixCalculate(postfixExpression)) == null) {
//            System.out.println("WRONG");
//        } else {
//            System.out.println(result);
//        }
//    }
//
//    private static String[] normalizeString(char[] chars) {
//        StringBuilder result = new StringBuilder();
//        StringBuilder brackets = new StringBuilder();
//
//        for (int i = 0; i < chars.length; i++) {
//            char aChar = chars[i];
//            if (aChar == ' ') {
//                if (isInteger(chars[i - 1]) && isInteger(chars[i + 1])) {
//                    return null;
//                }
//            } else if (!isInteger(aChar) && !isOperand(aChar) && !isBrackets(aChar)) {
//                return null;
//            } else if (isBrackets(aChar)) {
//                brackets.append(aChar);
//                result.append(aChar).append(" ");
//            } else if (isOperand(aChar)) {
//                result.append(aChar).append(" ");
//            } else {
//                StringBuilder resultChar = new StringBuilder();
//                char nextChar;
//                resultChar.append(aChar);
//                while (i < chars.length - 1) {
//                    nextChar = chars[i + 1];
//                    if (isInteger(nextChar)) {
//                        resultChar.append(nextChar);
//                        i++;
//                    } else {
//                        break;
//                    }
//                }
//                result.append(resultChar).append(" ");
//            }
//        }
//        result.setLength(result.length() - 1);
//        if (!correctParenthesis(brackets.toString().toCharArray())) {
//            return null;
//        }
//        return result.toString().split(" ");
//    }
//
//    private static String[] getPostfixExpression(String[] str) {
//        Stack<String> stack = new Stack<>();
//        StringBuilder expression = new StringBuilder();
//        try {
//            for (String ch : str) {
//                if (isInteger(ch)) {
//                    expression.append(ch).append(" ");
//                } else if (isBrackets(ch)) {
//                    if (ch.equals("(")) {
//                        stack.push(ch);
//                    } else {
//                        String stackElement = "";
//                        do {
//                            stackElement = stack.back();
//                            if (!isBrackets(stackElement)) {
//                                expression.append(stackElement).append(" ");
//                            }
//                            stack.pop();
//                        } while (!stackElement.equals("("));
//                    }
//                } else if (isOperand(ch)) {
//                    int operandPriority = OPERAND_PRIORITY.get(ch);
//
//                    if (stack.isEmpty() || stack.back().equals("(")) {
//                        stack.push(ch);
//                    } else if (operandPriority == OPERAND_PRIORITY_1) {
//                        String stackOperand;
//                        do {
//                            stackOperand = stack.back();
//                            if (isBrackets(stackOperand)) {
//                                stack.push(ch);
//                                break;
//                            } else {
//                                expression.append(stackOperand).append(" ");
//                                stack.pop();
//                                if (stack.size() == 0) {
//                                    stack.push(ch);
//                                    break;
//                                }
//                            }
//                        } while (true);
//                    } else if (operandPriority == OPERAND_PRIORITY_2) {
//                        String operand;
//                        do {
//                            operand = stack.back();
//                            if (isBrackets(operand)) {
//                                stack.push(ch);
//                                break;
//                            } else if (OPERAND_PRIORITY.get(operand) < OPERAND_PRIORITY_2) {
//                                stack.push(ch);
//                                break;
//                            } else {
//                                expression.append(operand).append(" ");
//                                stack.pop();
//                                if (stack.isEmpty()) {
//                                    stack.push(ch);
//                                    break;
//                                }
//                            }
//                        } while (true);
//                    }
//                }
//            }
//            String operand;
//            while (!stack.isEmpty()) {
//                operand = stack.back();
//                stack.pop();
//                expression.append(operand).append(" ");
//            }
//            expression.setLength(expression.length() - 1);
//        } catch (Exception e) {
//            return null;
//        }
//        return expression.toString().split(" ");
//    }
//
//    private static Integer postfixCalculate(String[] postfixString) {
//        Stack<Integer> stack = new Stack<>();
//
//        try {
//            for (String str : postfixString) {
//                if (stack.isEmpty()) {
//                    stack.push(Integer.parseInt(str));
//                } else if (!isInteger(str)) {
//                    int a = stack.back();
//                    stack.pop();
//                    int b = stack.back();
//                    stack.pop();
//                    int result = calculate(a, b, str);
//                    stack.push(result);
//                } else {
//                    stack.push(Integer.parseInt(str));
//                }
//            }
//            if (stack.size() != 1) {
//                return null;
//            }
//        } catch (Exception e) {
//            return null;
//        }
//        return stack.back();
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
//    private static boolean isOperand(char ch) {
//        return isOperand(String.valueOf(ch));
//    }
//
//    private static boolean isOperand(String ch) {
//        return ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/");
//    }
//
//    private static boolean isInteger(char ch) {
//        return isInteger(String.valueOf(ch));
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
//    private static boolean isBrackets(char ch) {
//        return isBrackets(String.valueOf(ch));
//    }
//
//    private static boolean isBrackets(String ch) {
//        return ch.equals("(") || ch.equals(")");
//    }
//
//    private static boolean correctParenthesis(char[] val) {
//        Stack<Character> stack = new Stack<>();
//        Map<Character, Character> brackets = Map.of('(', ')');
//
//        for (Character ch : val) {
//            if (stack.isEmpty()) {
//                stack.push(ch);
//            } else if (brackets.containsKey(ch)) {
//                stack.push(ch);
//            } else if (stack.back() == getKeyForValue(ch, brackets)) {
//                stack.pop();
//            } else {
//                stack.push(ch);
//            }
//        }
//        return stack.size() == 0;
//    }
//
//    private static char getKeyForValue(Character ch, Map<Character, Character> brackets) {
//        for (Map.Entry<Character, Character> entry : brackets.entrySet()) {
//            if (entry.getValue() == ch) {
//                return entry.getKey();
//            }
//        }
//        return ' ';
//    }
//
//    static class Stack<T> {
//        private int size;
//        private int elementCount;
//        private Object[] stackArray;
//        private int top;
//
//        public Stack() {
//            stackArray = new Object[100_000];
//            top = -1;
//            size = 0;
//        }
//
//        public synchronized void push(T element) {
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
//        public T back() {
//            if (size != 0) {
//                return (T) stackArray[top];
//            }
//            return (T) "";
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
//            stackArray = new Object[100_000];
//            top = -1;
//            size = 0;
//        }
//    }
}
