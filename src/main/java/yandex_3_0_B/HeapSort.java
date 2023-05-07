package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] array = covertArrayStringToInteger(reader.readLine().split(" "));
        MyHeap heap = new MyHeap();
        for (int j : array) {
            heap.insert(j);
        }

        for (int i = 0; i <= heap.idx; i++) {
            System.out.print(heap.getElement(i) + " ");
        }
    }

    private static int[] covertArrayStringToInteger(String[] str) {
        int size = str.length;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = Integer.parseInt(str[i]);
        }
        return result;
    }

    private static class MyHeap {
        int[] items;
        int idx = -1;
        boolean itemsChange;
        int capacity = 100_001;
        public MyHeap() {
            items = new int[capacity];
        }

        public void insert(int item) {
            items[++idx] = item;
            int elementIndex = idx;
            itemsChange = true;
            while (!isRoot(elementIndex) && !isCorrectChild(elementIndex)) {
                int parentIndex = parentIndex(elementIndex);
                swap(elementIndex, parentIndex);
                elementIndex = parentIndex;
            }
//            for (int i = 0; i <= idx; i++) {
//                System.out.print(items[i] + " ");
//            }
        }

        public void extract(boolean flag) {
            if (flag) {
                System.out.println(items[idx]);
            }
            idx--;
        }

        public boolean isItemsChange() {
            return itemsChange;
        }
        boolean isRoot(int index) {
            return index == 0;
        }

        boolean isCorrectChild(int index) {
            return isCorrect(parentIndex(index), index);
        }

        int parentIndex(int index) {
            return (index - 1) / 2;
        }

        boolean isCorrect(int parentIndex, int childIndex) {
            if (!isValidIndex(parentIndex) || !isValidIndex(childIndex)) {
                return true;
            }
            return elementAt(parentIndex) - (elementAt(childIndex)) < 0;
        }

        int getElement(int index) {
            if (isItemsChange()) {
                sortHeap();
            }
            return items[index];
        }
        int elementAt(int index) {
            return items[index];
        }

        boolean isValidIndex(int index) {
            return index <= idx;
        }

        void swap(int index1, int index2) {
            int element1 = items[index1];
            int element2 = items[index2];
            items[index1] = element2;
            items[index2] = element1;
        }

        private void sortHeap() {
            itemsChange = false;
            int[] result = new int[capacity];
            int i = idx;
            int j;
            for (j = 0; j <= i; j++) {
                result[j] = pop();
            }
            idx = j - 1;
            items = result;
        }

        private int pop() {
            int result = elementAt(0);
            swap(0, idx);
            this.extract(false);

            int elementIndex = 0;
            while (!isLeaf(elementIndex) && !isCorrectParent(elementIndex)) {
                int smallerChildIndex = smallerChildIndex(elementIndex);
                swap(elementIndex, smallerChildIndex);
                elementIndex = smallerChildIndex;
            }
            return result;
        }

        boolean isLeaf(int index) {
            return !isValidIndex(leftChildIndex(index));
        }

        boolean isCorrectParent(int index) {
            return isCorrect(index, leftChildIndex(index)) && isCorrect(index, rightChildIndex(index));
        }

        int smallerChildIndex(int index) {
            int leftChildIndex = leftChildIndex(index);
            int rightChildIndex = rightChildIndex(index);

            if (!isValidIndex(rightChildIndex)) {
                return leftChildIndex;
            }

            if (elementAt(leftChildIndex) - (elementAt(rightChildIndex)) < 0) {
                return leftChildIndex;
            }

            return rightChildIndex;
        }

        int leftChildIndex(int index) {
            return 2 * index + 1;
        }

        int rightChildIndex(int index) {
            return 2 * index + 2;
        }
    }
}
