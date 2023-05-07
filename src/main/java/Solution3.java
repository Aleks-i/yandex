import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int minNOK = Integer.MAX_VALUE;
        int idxNOKI = 0;
        int idxNOKJ = 0;
        if (n >= 2 && n <= 1_000_000_000) {
            for (int i = 1; i < n; i++) {
                int NOK = lcm(i, n - i);
                if (NOK < minNOK) {
                    idxNOKI = i;
                    idxNOKJ = n - i;
                    minNOK = NOK;
                }
            }
        }
        System.out.println(idxNOKI + " " + idxNOKJ);
    }

    public static int lcm(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        int absNumber1 = Math.abs(number1);
        int absNumber2 = Math.abs(number2);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }
}
