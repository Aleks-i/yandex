package YandexBackendMeetUp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class YandexBar {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        String[] s = strings.get(0).split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        strings.remove(0);
        int k = Integer.parseInt(strings.get(n));

        List<String> ingredients = new ArrayList<>();
        Map<String, Integer> ingredientsMap = new HashMap<>();
        while (n + 1 < strings.size()) {
            String[] ingredient = strings.get(n + 1).split(" ");
            ingredients.add(strings.get(n + 1));
            ingredientsMap.put(ingredient[0], Integer.valueOf(ingredient[1]));
            strings.remove(n + 1);
        }
        strings.remove(n);
        List<String> res = new ArrayList<>();
        res.add(strings.get(n - 1));
        strings.remove(n - 1);
        Collections.reverse(strings);

        strings.forEach(str -> {
            if (!ingredients.isEmpty()) {
                String[] ingr = ingredients.get(0).split(" ");
                res.add(str.replaceAll(" ", ingr[2]));
                ingredientsMap.compute(ingr[0], (key, v) -> v - 1);
                if (ingredientsMap.get(ingr[0]) == 0){
                    ingredients.remove(0);
                }
            } else {
                res.add(str);
            }

        });
        Collections.reverse(res);
        res.forEach(System.out::println);
    }
}
