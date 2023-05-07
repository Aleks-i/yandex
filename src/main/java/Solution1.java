import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String s = reader.readLine();
        String b = reader.readLine();
        int countUglyWords = 0;
        if (n >= 1 && n <= 100 && s.replaceAll("\\s+", "").length() >= 1
                && s.replaceAll("\\s+", "").length() <= 100 && b.replaceAll("\\s+", "").length() == n) {
            String[] arrayOfString = s.split("\\s+");
            boolean uglyWord = false;
            for (String word : arrayOfString) {
                for (int j = 0; j < word.length(); j++) {
                    if (j != word.length() - 1) {
                        if (b.charAt(j) == b.charAt(j + 1)) {
                            uglyWord = true;
                        }
                    }
                }
                if (uglyWord) {
                    countUglyWords++;
                    uglyWord = false;
                }
                b = b.substring(word.length());
            }
        }
        System.out.println(countUglyWords);
    }
}
