package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyFirstHeap {

//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int countCommand = Integer.parseInt(reader.readLine());
//        String[] command = new String[2];
//        MyHeap heap = new MyHeap();
//
//        while (countCommand != 0) {
//            command = reader.readLine().split(" ");
//            switch (command[0]) {
//                case "0" -> {
//                    if (command.length < 2) {
//                        break;
//                    }
//                    heap.insert(Integer.parseInt(command[1]));
//                }
//                case "1" -> {
//                    if (heap.isItemsChange()) {
//                        heap.sortHeap();
//                    }
//                    heap.extract(true);
//                }
//            }
//            countCommand--;
//        }
//    }

    private static class MyHeap {
        int[] items;
        int idx = -1;
        boolean itemsChange;

        public MyHeap() {
            items = new int[50_001];
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
            itemsChange =false;
            int[] result = new int[50_001];
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
