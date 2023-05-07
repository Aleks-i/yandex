package yandex_3_0_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Conveyor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] arrayResult = new int[n];
        for (int k = 0; k < n; k++) {
            String[] line = reader.readLine().split(" ");
            int countWagon = Integer.parseInt(line[0]);
            double[] wagonsNumer = new double[countWagon];
            for (int j = 0; j < countWagon; j++) {
                wagonsNumer[j] = Double.parseDouble(line[j + 1]);
            }

            Stack<Double> stack = new Stack<>();
            List<Double> wagonsSort = new ArrayList<>();
            for (int i = 0; i < wagonsNumer.length; i++) {
                double wN = wagonsNumer[i];
                if (i == 0) {
                    stack.push(wN);
                } else if (!stack.isEmpty() && stack.peek() < wN) {
                    while (!stack.isEmpty() && wN > stack.peek()) {
                        wagonsSort.add(stack.peek());
                        stack.pop();
                    }
                    stack.push(wN);
                } else if (!stack.isEmpty() && stack.peek() > wN) {
                    stack.push(wN);
                }
            }
            while (!stack.isEmpty()) {
                wagonsSort.add(stack.pop());
            }
            int result = 1;

            List<Double> listToCompare = new ArrayList<>(wagonsSort);
            Collections.sort(listToCompare);
            if (!listToCompare.equals(wagonsSort)) {
                result = 0;
            }
            arrayResult[k] = result;
        }
        for (Integer i : arrayResult) {
            System.out.println(i);
        }
    }
}
