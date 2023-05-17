package code_run.back;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AgainJSONsShift {
    public static void main(String[] args) throws IOException, ParseException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int[] countLimit = Arrays.stream(strings.get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int count = countLimit[0];
        int limit = countLimit[1];

        JSONParser parser = new JSONParser();
        JSONArray offers = new JSONArray();
        for (int i = 1; i <= count; i++) {
            JSONObject jsonObject = (JSONObject) parser.parse(strings.get(i));
            JSONArray offersArr = (JSONArray) jsonObject.get("offers");
            offers.addAll(offersArr);
        }

        JSONArray resArr = new JSONArray();
        limit = Math.min(offers.size(), limit);
        for (int i = 0; i < limit; i++) {
            JSONObject obj = (JSONObject) offers.get(i);
            resArr.add(i, obj);
        }
        HashMap<String, JSONArray> map = new HashMap<>();
        map.put("offers", resArr);
        JSONObject res = new JSONObject(map);
        System.out.println(res);

    }
}
