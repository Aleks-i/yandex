package yandex_1._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String[]> vertexes = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        String[] prev = reader.readLine().split(" ");
        int[] prefixSum = new int[n];
        for (int i = 1; i < prefixSum.length; i++) {
            vertexes.add(prev);
            String[] vert = reader.readLine().split(" ");
            int diff = Integer.parseInt(vert[1]) - Integer.parseInt(prev[1]);
            int psi = Math.max(diff, 0);
            prefixSum[i] = prefixSum[i - 1] + psi;
            prev = vert;
        }
        vertexes.add(prev);
        Collections.reverse(vertexes);

        Integer[] prefixSumReverse = new Integer[n];
        prefixSumReverse[0] = 0;
        prev = vertexes.get(0);
        for (int i = 1; i < prefixSumReverse.length; i++) {
            String[] vert = vertexes.get(i);
            int diff = Integer.parseInt(prev[1]) - Integer.parseInt(vert[1]);
            int psi = Math.min(diff, 0);
            prefixSumReverse[i] = prefixSumReverse[i - 1] - psi;
            prev = vert;
        }

        Collections.reverse(Arrays.asList(prefixSumReverse));
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            int[] track = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int vertex1 = track[0];
            int vertex2 = track[1];
            if (vertex1 <= vertex2) {
                System.out.println(prefixSum[vertex2 - 1] - prefixSum[vertex1 - 1]);
            } else {
                System.out.println(prefixSumReverse[vertex2 - 1] - prefixSumReverse[vertex1 - 1]);
            }
        }
//
//        System.out.println(Arrays.toString(prefixSum));
//        System.out.println(Arrays.toString(prefixSumReverse));
    }
}
