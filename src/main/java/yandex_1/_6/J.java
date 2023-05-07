package yandex_1._6;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class J {
    static PrintWriter consoleOutput = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int n = Integer.parseInt(strings.get(0).split(" ")[0]);
        int k = Integer.parseInt(strings.get(0).split(" ")[1]);
        strings.remove(0);
        int[][] s = new int[n][k];
        for (int i = 0; i < n; i++) {
            s[i] = Arrays.stream(strings.get(i).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < s.length - 1; i++) {
            for (int j = i + 1; j < s.length; j++) {
                consoleOutput.println(getLeftMedianMerge(s[i], s[j]));
            }
        }

        consoleOutput.flush();
        consoleOutput.close();
    }

    private static int getLeftMedianMerge(int[] seq1, int[] seq2) {
        int low = Math.min(seq1[0], seq2[0]);
        int high = Math.max(seq1[seq1.length - 1], seq2[seq2.length - 1]);
        int mid = 0;
        if (seq1.length == 1) {
            return Math.min(seq1[0], seq2[0]);
        }
        while (high - low != 0) {
            mid = low + (high - low) / 2;
            int[] countLR = getCountLR(seq1, seq2, mid);
            if (isAccord(countLR[0], countLR[1], seq1.length)) {
                return mid;
            } else if (countLR[0] <= seq1.length - 1 && countLR[1] > seq1.length) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static boolean isAccord(int cL, int cR, int length) {
        return cL == length - 1 && cR == length;
    }

    private static int[] getCountLR(int[] seq1, int[] seq2, int mid) {
        int idx1 = getidxLeft(seq1, mid);
        int idx2 = getidxLeft(seq2, mid);
        int countLeft = idx1 + idx2;
        int countRight = getIdxRight(seq1, mid) + getIdxRight(seq2, mid);

        if (seq1.length > idx1 && seq1[idx1] == seq2[idx2]) {
            countLeft++;
        }
        if (seq1[seq1.length - 1] <= mid) {
            countLeft++;
        }
        if (seq2[seq2.length - 1] <= mid) {
            countLeft++;
        }

        int i = idx1;
        int j = idx2;
        int cL = countLeft;
        int cR = countRight;
        if (i > 0 && seq1[i] == seq1[i - 1]) {
            int diffL = 1;
            while (i > 0 && seq1[i] == seq1[i - 1]) {
                cL -= diffL;
                cR += diffL;
                if (isAccord(cL, cR, seq1.length)) {
                    return new int[]{cL, cR};
                }
                if (j > 0 && seq2[j] == seq2[j - 1]) {
                    int diffR = diffL + 1;
                    while (j > 0 && seq2[j] == seq1[j - 1]) {
                        cL -= diffR;
                        cR += diffR;
                        if (isAccord(cL, cR, seq1.length)) {
                            return new int[]{cL, cR};
                        }
                        diffR++;
                        j--;
                    }
                }
                diffL++;
                i--;
            }
        }
        return new int[]{countLeft, countRight};
    }

    private static int getidxLeft(int[] seq, int t) {
        int idx = binarySearch(seq, t);
        if (t > seq[seq.length - 1]) {
            return seq.length - 1;
        } else if (seq[0] == t) {
            return 0;
        }
        return idx;
    }

    private static int getIdxRight(int[] seq, int t) {
        int idx = getidxLeft(seq, t);
        if (seq[idx] == t) {
            return seq.length - idx - 1;
        }
        return seq.length - idx;
    }

    private static int binarySearch(int[] seq, int t) {
        int l = 0;
        int r = seq.length - 1;
        while (r - l != 0) {
            int mid = l + (r - l) / 2;
            if (seq[mid] < t) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
