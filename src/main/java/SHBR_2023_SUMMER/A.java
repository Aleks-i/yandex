package SHBR_2023_SUMMER;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class A {
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

        DataCenter[] dc = new DataCenter[n];
        IntStream.range(0, n).forEach(i -> {
            dc[i] = new DataCenter(0, 0, m);
        });

        for (int i = 0; i < q; i++) {
            String[] query = strings.get(i).split(" ");

            DataCenter dataCenter;
            switch (query[0]) {
                case "DISABLE":
                    dataCenter = dc[Integer.parseInt(query[1]) - 1];
                    dataCenter.switchOffServer(Integer.parseInt(query[2])  - 1);
                    break;
                case "RESET":
                    dataCenter = dc[Integer.parseInt(query[1]) - 1];
                    dataCenter.reset(m);
                    break;
                case "GETMAX":

                    break;
                case "GETMIN":

                    break;
            }

        }

        consoleOutput.println(Arrays.deepToString(dc));
        consoleOutput.flush();
        consoleOutput.close();
    }

    private static class DataCenter {
        private int a;
        private int r;
        private int activeServers;
        private boolean[] isNotActiveServer;

        public DataCenter(int a, int r, int countServers) {
            this.a = a;
            this.r = r;
            this.activeServers = countServers;
            isNotActiveServer = new boolean[countServers];
        }

        public void switchOffServer(int server) {
            int serverIdx = server - 1;
            if (!isNotActiveServer[serverIdx]) {
                activeServers--;
                isNotActiveServer[server - 1] = true;
            }
        }

        public void reset(int countServers) {
            isNotActiveServer = new boolean[countServers];
            r++;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getActiveServers() {
            return activeServers;
        }

        public void setActiveServers(int activeServers) {
            this.activeServers = activeServers;
        }

        public boolean[] getIsNotActiveServer() {
            return isNotActiveServer;
        }

        public void setIsNotActiveServer(boolean[] isNotActiveServer) {
            this.isNotActiveServer = isNotActiveServer;
        }

        @Override
        public String toString() {
            return "DataCenter{" +
                    "a=" + a +
                    ", r=" + r +
                    ", isActiveServer=" + isNotActiveServer +
                    '}';
        }
    }
}
