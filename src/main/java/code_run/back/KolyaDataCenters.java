package code_run.back;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

public class KolyaDataCenters {
//    static long startTime = System.nanoTime();
    static TreeMap<Long, TreeSet<Integer>> RAStorage = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        PrintWriter consoleOutput = new PrintWriter(System.out);
        int[] val = Arrays.stream(strings.get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        strings.remove(0);

        int n = val[0];
        int m = val[1];
        int q = val[2];

        DataCenter[] dcStorage = new DataCenter[n];
        RAStorage.put(0L, new TreeSet<>());
        IntStream.range(0, n).forEach(i -> {
            dcStorage[i] = new DataCenter(i + 1, m);
        });

        DataCenter dataCenter;
        for (int i = 0; i < q; i++) {
            String[] query = strings.get(i).split(" ");

            switch (query[0]) {
                case "DISABLE" -> {
                    dataCenter = dcStorage[Integer.parseInt(query[1]) - 1];
                    dataCenter.switchOffServer(Integer.parseInt(query[2]));
                }
                case "RESET" -> {
                    dataCenter = dcStorage[Integer.parseInt(query[1]) - 1];
                    dataCenter.reset(m);
                }
                case "GETMAX" -> consoleOutput.println(RAStorage.lastEntry().getValue().first());
                case "GETMIN" -> {
                    consoleOutput.println(RAStorage.firstEntry().getValue().first());}
            }
        }
//        consoleOutput.flush();
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime) / 1000000;
//        consoleOutput.println(duration);
        consoleOutput.flush();
        consoleOutput.close();
    }

    private static class DataCenter implements Comparable<DataCenter> {
        int id;
        int a;
        int r;
        long RA;
        Set<Integer> isNotActiveServers;

        public DataCenter(int id, int countServers) {
            this.id = id;
            this.a = countServers;
            this.r = 0;
            this.RA = 0;
            RAStorage.get(RA).add(id);
            isNotActiveServers = new HashSet<>();
        }

        public void switchOffServer(int server) {
            long RAOld = RA;
            if (!isNotActiveServers.contains(server)) {
                a--;
                isNotActiveServers.add(server);
                RA = (long) r * a;
            }
            setNewRA(RAOld);
        }

        public void reset(int countServers) {
            isNotActiveServers = new HashSet<>();
            a = countServers;
            r++;
            long RAOld = RA;
            RA = (long) r * a;
            setNewRA(RAOld);
        }

        private void setNewRA(long RAOld) {
            if (RAOld != RA) {
                TreeSet<Integer> dcSet = RAStorage.get(RAOld);
                if (dcSet != null) {
                    dcSet.remove(id);
                    if (dcSet.isEmpty()) {
                        RAStorage.remove(RAOld);
                    }
                    RAStorage.putIfAbsent(RA, new TreeSet<>());
                    RAStorage.get(RA).add(id);
                }
            }
        }

        @Override
        public int compareTo(DataCenter dataCenter) {
            return this.id - dataCenter.id;
        }

        @Override
        public String toString() {
            return "DataCenter{" +
                    "a=" + a +
                    ", r=" + r +
                    ", isActiveServer=" + isNotActiveServers.toString() +
                    '}';
        }
    }
}
