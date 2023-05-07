package yandex_1._6;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class B {
    public static void main(String[] args) throws IOException {
        PrintWriter consoleOutput = new PrintWriter(System.out);
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int[] str = Arrays.stream(strings.get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (str[0] != 0 & str[1] != 0) {
            int[] arr1 = Arrays.stream(strings.get(1).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] arr2 = Arrays.stream(strings.get(2).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
//            List<Integer> list = new ArrayList<>();
            for (Integer i : arr2) {
                int low = 0;
                int high = arr1.length - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (arr1[mid] == i) {
//                        list.add(i);
                        consoleOutput.println(i);
                        break;
                    } else if (arr1[high] < i) {
//                        list.add(getNearestOrMinNumber(arr1, high, i));
                        consoleOutput.println(getNearestOrMinNumber(arr1, high, i));
                        break;
                    } else if (arr1[low] > i) {
//                        list.add(getNearestOrMinNumber(arr1, low - 1, i));
                        consoleOutput.println(getNearestOrMinNumber(arr1, low - 1, i));
                        break;
                    } else if (arr1[mid] < i) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        consoleOutput.flush();
        consoleOutput.close();
    }

    private static int getNearestOrMinNumber(int[] arr, int nearestIdx, int target) {
        if (target < arr[0]) {
            return arr[0];
        } else if (target > arr[arr.length - 1]) {
            return arr[arr.length - 1];
        } else if (target - arr[nearestIdx] < arr[nearestIdx + 1] - target) {
            return arr[nearestIdx];
        } else if (target - arr[nearestIdx] > arr[nearestIdx + 1] - target) {
            return arr[nearestIdx + 1];
        } else {
            return Math.min(arr[nearestIdx], arr[nearestIdx + 1]);
        }
    }
}
