package yandex_3_0_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CorruptXML {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = reader.readLine().toCharArray();
        StringBuilder sb;
        List<String> tagList = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            sb = new StringBuilder();
            sb.append(chars[i]);
            if (i != chars.length - 1) {
                do {
                    i++;
                    sb.append(chars[i]);
                } while (i != chars.length - 2 && (chars[i] != '>' || chars[i + 1] != '<'));
                if (i == chars.length - 2) {
                    i = chars.length - 1;
                    sb.append(chars[i]);
                }
            }
            tagList.add(sb.toString());
        }

        System.out.println(tagList);
    }
}
