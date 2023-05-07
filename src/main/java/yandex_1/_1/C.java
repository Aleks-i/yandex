package yandex_1._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        for (int i = 0; i < 3; i++) {
            if (checkNumber(number, reader.readLine())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean checkNumber(String number, String existNumber) {
        return getValidNumber(number).equals(getValidNumber(existNumber));
    }

    private static String getValidNumber(String number) {
        StringBuilder sb = new StringBuilder();
        String n = number.replace("-", "");
        if (n.length() == 7) {
            sb.append("495").append(n);
        } else if (n.contains("(") && n.contains(")")) {
            int charIndexS = n.indexOf("(");
            int charIndexE = n.indexOf(")");
            if (charIndexE - charIndexS < 2) {
                sb.append("495");
            } else {
                sb.append(n, charIndexS + 1, charIndexE);
            }
            sb.append(n.substring(charIndexE + 1));
        } else if (n.length() == 9) {
            sb.append("495");
            sb.append(n.substring(2));
        } else if (n.length() == 8) {
            sb.append("495");
            sb.append(n.substring(1));
        } else if (n.charAt(0) == '+' && n.charAt(1) == '7') {
            sb.append(n.substring(2));
        } else if (n.charAt(0) == '8') {
            sb.append(n.substring(1));
        }
        return sb.toString();
    }
}
