package yandex_1._7;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class A {
    public static void main(String[] args) throws IOException {
        long start;
        double duration;

        start = System.currentTimeMillis();
        PrintWriter consoleOutput = new PrintWriter(System.out);
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int[] counts = Arrays.stream(strings.get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = counts[0];
        int m = counts[1];
        strings.remove(0);

//        int[] desks = new int[n];
//        int cS = 0;
//        strings.forEach(s -> {
//            String[] str = s.split(" ");
//            int l = Integer.parseInt(str[0]);
//            int h = Integer.parseInt(str[1]);
//            for (int i = l; i <= h; i++) {
//                desks[i] = 1;
//            }
//        });
//        duration = (System.currentTimeMillis() - start) / 1000.;
//        for (int i : desks) {
//            if (i == 0) {
//                cS++;
//            }
//        }

        Set<Observer> desks = new TreeSet<>();
        strings.forEach(elem -> {
            String[] str = elem.split(" ");
            int s = Integer.parseInt(str[0]);
            int e = Integer.parseInt(str[1]);
            desks.add(new Observer(s, e));
        });

        List<Observer> observers = new ArrayList<>();
        Iterator<Observer> it = desks.iterator();
        Observer prev = it.next();
        int i = 0;
        observers.add(0, prev);
        while (it.hasNext()) {
            Observer current = it.next();
            if (prev.contains(current)) {
                Observer observer = new Observer(Math.min(prev.start, current.start), Math.max(prev.end, current.end));
                observers.set(i, observer);
                prev = observer;
            } else {
                observers.add(++i, current);
                prev = current;
            }
        }

        AtomicInteger cD = new AtomicInteger();
        observers.forEach(o -> {
            cD.addAndGet(o.end - o.start + 1);
        });

        duration = (System.currentTimeMillis() - start) / 1000.;
//        desks.forEach(System.out::println);
//        consoleOutput.println(duration);
        consoleOutput.println(n - cD.get());
        consoleOutput.flush();
        consoleOutput.close();
    }

    private static class Observer implements Comparable<Observer>, Comparator<Observer> {
        int start;
        int end;

        public Observer(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Observer o) {
            return compare(this, o);
        }

        public boolean contains(Observer o) {
            return this.start <= o.end && this.end + 1 >= o.start ;
        }

        @Override
        public int compare(Observer o1, Observer o2) {
            if (o1.start == o2.start && o1.end == o2.end) {
                return 0;
            } else if (o1.start <= o2.start) {
                return -1;
            }
            return 1;
        }

        @Override
        public String toString() {
            return "Observer{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
