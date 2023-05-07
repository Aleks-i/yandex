package yandex_1._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class I {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        int[] sidesBrick = sort(new int[]{a, b, c});
        int[] sidesHole = sort(new int[]{d, e});

//        for (int i = 0; i < 100000; i++) {
//            int[] arr1 = generateRandomIntArr(3);
//            int[] arr2 = generateRandomIntArr(2);
//            if (compare(sort(arr1), sort(arr2)) != compare1(arr1, arr2)) {
//                System.out.println(Arrays.toString(arr1));
//                System.out.println(Arrays.toString(arr2));
//            }
//        }

        if (compare(sidesBrick, sidesHole)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    private static boolean compare(int[] sidesBrick, int[] sidesHole) {
        return sidesBrick[0] <= 0 || sidesBrick[1] <= 0 || sidesHole[0] <= 0 || sidesHole[1] <= 0 ||
                sidesBrick[0] > sidesHole[0] || sidesBrick[1] > sidesHole[1];
    }

    private static boolean compare1(int[] arr1, int[] arr2) {
        int a = arr1[0];
        int b = arr1[1];
        int c = arr1[2];
        int d = arr2[0];
        int e = arr2[1];
        if (a <= 0 || b <= 0 || c <= 0 || d <= 0 || e <= 0) {
            return true;
        } else if (a <= d && b <= e || a <= e && b <= d) {
            return false;
        } else if (a <= d && c <= e || a <= e && c <= d) {
            return false;
        } else return (b > d || c > e) && (b > e || c > d);
    }

    private static int[] sort(int[] arr) {
        int lastIdx = arr.length - 1;
        for (int j = 0; j <= lastIdx; j++) {
            for (int i = 0; i < lastIdx; i++) {
                if (arr[i] > arr[i + 1]) {
                    int swap = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = swap;
                }
            }
            lastIdx--;
        }
        return Arrays.copyOfRange(arr, 0, 2);
//        return arr;
    }

    private static int[] generateRandomIntArr(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000) + 1;
        }
        return arr;
    }
}
