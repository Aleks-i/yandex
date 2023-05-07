package yandex_3_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UndergroundDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Wagon> a = new ArrayList<>();
        Stack<Wagon> wagonStack = new Stack<>();

        Map<String, Long> storage = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int restWagons;
            String[] str = reader.readLine().split(" ");
            switch (str[0]) {
                case "add":
                    storage.computeIfPresent(str[2], (k, v) -> v + Integer.parseInt(str[1]));
                    storage.putIfAbsent(str[2], Long.valueOf(str[1]));
                    a.add(new Wagon(str[2], Integer.parseInt(str[1])));
                    wagonStack.push(new Wagon(str[2], Integer.parseInt(str[1])));
                    break;
                case "delete":
                    restWagons = Integer.parseInt(str[1]);
                    for (int j = a.size() - 1; j >= 0; j --) {
                        Wagon w = wagonStack.peek();
                        if( w.count > restWagons) {
                            int finalRestWagons = restWagons;
                            storage.compute(w.name, (k, v) -> v - finalRestWagons);
                            w.count -= restWagons;
                            a.set(j, w);
                            break;
                        } else {
                            restWagons -= w.count;
                            storage.compute(w.name, (k, v) -> v - w.count);
                            wagonStack.pop();
                            a.remove(j);
                        }
//                        if (restWagons <= a.get(j).count) {
//                            int finalRestWagons = restWagons;
//                            storage.compute(a.get(j).name, (k, v) -> v - finalRestWagons);
//                            a.get(j).count = a.get(j).count - restWagons;
//                            break;
//                        } else {
//                            restWagons = restWagons - storage.get(a.get(j).name);
//                            storage.put(a.get(j).name, 0);
//                            a.remove(j);
//                        }
                    }
                    break;
                case "get":
                    Long count = storage.get(str[1]);
                    if (count == null) {
                        System.out.println(0);
                    } else {
                        System.out.println(count);
                    }
                    break;
            }
        }
    }
    private static class Wagon {
        String name;
        long count;

        public Wagon(String name, long count) {
            this.name = name;
            this.count = count;
        }
    }
}
