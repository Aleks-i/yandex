package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectorDiego {

//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(reader.readLine());
//        String[] strDiegoNumbers = reader.readLine().split(" ");
//        Set<String> setDiegoNumbers = new HashSet<>(List.of(strDiegoNumbers));
//        int k = Integer.parseInt(reader.readLine());
//        String[] strLowestCollectorNumber = reader.readLine().split(" ");
//
//        strDiegoNumbers = setDiegoNumbers.toArray(new String[0]);
//        int[] diegoNumbers = converStringToIntArray(strDiegoNumbers);
//        int[] lowestCollectorNumber = converStringToIntArray(strLowestCollectorNumber);
//
//        Arrays.sort(diegoNumbers);
//        int[] countStickersForCollectioners = new int[lowestCollectorNumber.length];
//        for (int i = 0; i < countStickersForCollectioners.length; i++) {
//            int nearestIdx = getNearestIdx(diegoNumbers, lowestCollectorNumber[i], 0, diegoNumbers.length - 1);
//            if (nearestIdx < 0) {
//                countStickersForCollectioners[i] = 0;
//            } else if (nearestIdx == diegoNumbers.length) {
//                countStickersForCollectioners[i] = diegoNumbers.length;
//            } else {
//                nearestIdx = diegoNumbers[nearestIdx] == lowestCollectorNumber[i] ? nearestIdx - 1 : nearestIdx;
//                countStickersForCollectioners[i] = computCountSticker(nearestIdx);
//            }
//        }
//
//        for (int i = 0; i < countStickersForCollectioners.length; i++) {
//            System.out.println(countStickersForCollectioners[i]);
//        }
//    }
//
//    private static int getNearestIdx(int[] diegoNumbers, int key, int low, int high) {
//        while (true) {
//            int middle = (low + high) / 2;
//            if (diegoNumbers[middle] == key) {
//                return middle;
//            } else if (key > diegoNumbers[diegoNumbers.length - 1]) {
//                return diegoNumbers.length;
//            } else if (key < diegoNumbers[0]) {
//                return -1;
//            } else if (middle == 0) {
//                return diegoNumbers[middle] < key ? middle : -1;
//            } else if ((diegoNumbers[middle] > key && diegoNumbers[middle - 1] <= key)) {
//                return middle - 1;
//            } else if ((diegoNumbers[middle] < key && diegoNumbers[middle + 1] >= key)) {
//                return middle;
//            } else if (diegoNumbers[middle] < key) {
//                low = middle + 1;
//            } else {
//                high = middle - 1;
//            }
//        }
//    }
//
//    private static int computCountSticker(int nearestIdx) {
//        int countStickers = 0;
//        for (int i = 0; i <= nearestIdx; i++) {
//            countStickers++;
//        }
//        return countStickers;
//    }
//
//    private static int[] converStringToIntArray(String[] strArray) {
//        int[] intArray = new int[strArray.length];
//        for (int i = 0; i < strArray.length; i++) {
//            intArray[i] = Integer.parseInt(strArray[i]);
//        }
//        return intArray;
//    }
}
