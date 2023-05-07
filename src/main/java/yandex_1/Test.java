package yandex_1;

public class Test {
    public static void main(String[] args) {
        int[] test = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        System.out.println(binarySearch(test, 8));
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
