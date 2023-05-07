import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2 {
    static int[] countDoubleReader = new int[25];
    static StringBuilder result = new StringBuilder();
    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static int k;
    static int counter;
    public static void main(String[] args) throws IOException {
        Arrays.fill(countDoubleReader, 1);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] string = reader.readLine().split(" ");
        int n =Integer.parseInt(string[0]); // количество символов
        k = Integer.parseInt(string[1]); //количество заклинаний
        String[] m = reader.readLine().split("(?!^)"); //строка из книги
        String[] str1 = reader.readLine().split(" ");
        String[] str2 = reader.readLine().split(" ");
        int[] characterPosition = fillArray(str1); //позиция символа
        int[] shift = fillArray(str2); //сдвиг позиции

        int startIndex = characterPosition[0];
        String resultStr = addSymbolToStrinBuilder(startIndex, m, characterPosition, shift);
        System.out.println(resultStr);
    }

    private static String addSymbolToStrinBuilder(int index, String[] str, int[] characterPosition, int[] shift) {
        if (counter == k) {
            return result.toString();
        } else if (countDoubleReader[index] == 1 && index <= str.length) {
            result.append(str[index - 1]);
            countDoubleReader[index]++;
            counter++;
            addSymbolToStrinBuilder(characterPosition[index - 1], str, characterPosition, shift);
        } else if (countDoubleReader[index] != 1) {
            int indexNew = (new String(alphabet).indexOf(str[index - 1]));
            int indexFromAlphabet = getIndexForMod26(indexNew + (characterPosition[index - 1] - 1) * shift[index - 1]);
            char ch = result.toString().charAt(result.toString().length() - 1);
            if (new String(alphabet).indexOf(ch) == indexNew) {
                addSymbolToStrinBuilder(shift[index - 1], str, characterPosition, shift);
            }
            result.append(alphabet[indexFromAlphabet]);
            counter++;
            addSymbolToStrinBuilder(indexFromAlphabet, str, characterPosition, shift);
        }
        return result.toString();
    }

    private static int getIndexForMod26(int index) {
        if (index > 25) {
            index = getIndexForMod26(index - 25) - 1;
        }
        return index;
    }

    private static int[] fillArray(String[] array) {
        int[] resultArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resultArray[i] = Integer.parseInt(array[i]);
        }
        return resultArray;
    }
}
