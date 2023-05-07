package code_run.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SortingPositiveNumbersReverseOrder {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        StringBuilder sb = new StringBuilder();
        sb.append(strings.get(0)).append(":").append(strings.get(1)).append("/?a=")
                .append(strings.get(2)).append("&b=").append(strings.get(3));

        URL url = new URL(sb.toString());
        URLConnection con = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
    }
}
