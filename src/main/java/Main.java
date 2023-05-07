import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int maxCountFigure = 0;
        List<Integer> indexFigure = new ArrayList<>();
        int currentTime = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] values = reader.readLine().split(" ");
        int n = Integer.parseInt(values[0]); //количество фигур
        int x = Integer.parseInt(values[1]); //идеальный вес
        int t = Integer.parseInt(values[2]); //минуты

        String[] string = reader.readLine().split(" ");
        int[] figureMasses = new int[string.length];
        for (int i = 0; i < string.length; i++) {
            figureMasses[i] = Integer.parseInt(string[i]);
        }

        Map<Integer, Integer> timeToPerfectMass = new HashMap<>();
        for (int i = 0; i < figureMasses.length; i++) {
            int timeToPerfectFigure = Math.abs(x - figureMasses[i]);
            if (timeToPerfectFigure < t) {
                timeToPerfectMass.put(i, timeToPerfectFigure);
            }
        }

        Map<Integer, Integer> sortedMap = valueSort(timeToPerfectMass);

        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            int time = entry.getValue();
            if ((currentTime + time) <= t) {
                maxCountFigure++;
                indexFigure.add(entry.getKey() + 1);
                currentTime += time;
            }
        }

        System.out.println(maxCountFigure);

        if (indexFigure.isEmpty()) {
            System.out.println(0);
        }
        StringBuilder resultNumbersFigures = new StringBuilder();
        indexFigure.forEach(i -> resultNumbersFigures.append(i).append(" "));
        System.out.println(resultNumbersFigures.toString().trim());
    }

    public static <K, V extends Comparable<V>> Map<K, V> valueSort(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                int comp = map.get(k1).compareTo(
                        map.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
        };

        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);
        sorted.putAll(map);
        return sorted;
    }
}
