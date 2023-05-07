package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinelandResettlement {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        City[] cities = getArrayCities(reader.readLine().split(" "));

        Stack stack = new Stack();

        for (int i = 0; i < cities.length; i++) {
            City city = cities[i];
            if (stack.isEmpty() || stack.back().getCost() < city.getCost()) {
                stack.push(city);
            } else {
                City cityFromStack = stack.back();
                while (!stack.isEmpty() && (cityFromStack = stack.back()).getCost() > city.getCost()) {
                    cityFromStack.setNumberCityForResettlement(i);
                    stack.pop();
                }
                stack.push(city);
            }
        }

        for (City city : cities) {
            System.out.print(city.getNumberCityForResettlement() + " ");
        }
    }

    private static City[] getArrayCities(String[] str) {
        int size = str.length;
        City[] result = new City[size];
        for (int i = 0; i < size; i++) {
            result[i] = new City(i, Integer.parseInt(str[i]), -1);
        }
        return result;
    }

    static class Stack {
        private int size;
        private int elementCount;
        private City[] stackArray;
        private int top;
        private final int capacity = 100_001;

        public Stack() {
            stackArray = new City[capacity];
            top = -1;
            size = 0;
        }

        public synchronized void push(City element) {
            elementCount++;
            top++;
            stackArray[top] = element;
            size++;
        }

        public synchronized void pop() {
            elementCount--;
            size--;
            top--;
        }

        public City back() {
            return stackArray[top];
        }

        public void size() {
            System.out.println(size);
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public synchronized void clear() {
            stackArray = new City[capacity];
            top = -1;
            size = 0;
        }
    }

    private static class City {
        int number;
        int cost;
        int numberCityForResettlement;

        public City(int number, int cost, int numberCityForResettlement) {
            this.number = number;
            this.cost = cost;
            this.numberCityForResettlement = numberCityForResettlement;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getNumberCityForResettlement() {
            return numberCityForResettlement;
        }

        public void setNumberCityForResettlement(int numberCityForResettlement) {
            this.numberCityForResettlement = numberCityForResettlement;
        }
    }
}
