package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OperatingSystems {
    private static int countOperatingSystem;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        List<DiskPartition> diskPartitions = new ArrayList<>();

        int startSector;
        int endSector;
        while (n != 0) {
            String[] str = reader.readLine().split(" ");
            startSector = Integer.parseInt(str[0]);
            endSector = Integer.parseInt(str[1]);
            DiskPartition diskPartition = new DiskPartition(startSector, endSector);
            if (diskPartitions.isEmpty()) {
                diskPartitions.add(diskPartition);
                countOperatingSystem++;
            } else {
                diskPartitions.forEach(dp -> {
                    if (!dp.erase) {
                        dp.checkAccord(diskPartition);
                    }
                });
                diskPartitions.add(diskPartition);
                countOperatingSystem++;
            }
            n--;
        }
        System.out.println(countOperatingSystem);
    }

    private static class DiskPartition {
        int startSector;
        int endSector;

        boolean erase;

        public DiskPartition(int startSector, int endSector) {
            this.startSector = startSector;
            this.endSector = endSector;
        }

        public void checkAccord(DiskPartition diskPartition) {
            if (this.startSector <= diskPartition.endSector && diskPartition.startSector <= this.endSector) {
                erase = true;
                countOperatingSystem--;
            }
        }

        public boolean isErase() {
            return erase;
        }
    }
}
