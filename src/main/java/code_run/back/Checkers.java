package code_run.back;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Checkers {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int[] sizes = Arrays.stream(strings.get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Checker[][] field = new Checker[sizes[1]][sizes[0]];
        boolean isWhite = false;
        for (int i = 1; i < strings.size(); i++) {
            int lastIdxForWhite = Integer.parseInt(strings.get(i++)) + i - 1;
            for (; i <= lastIdxForWhite; i++) {
                createChecker(strings.get(i).split(" "), true, field);
            }
            int lastIdxBlack = Integer.parseInt(strings.get(i++)) + i - 1;
            for (; i <= lastIdxBlack; i++) {
                createChecker(strings.get(i).split(" "), false, field);
            }
            if (strings.get(i).equals("white")) {
                isWhite = true;
            }
        }

        boolean isCutDown = false;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] != null) {
                    Checker ch = field[i][j];
                    if (ch.isWhite == isWhite && ch.isCutDown(field, isWhite)) {
                        isCutDown = true;
                    }
                }
            }
        }

        if (isCutDown) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void createChecker(String[] str, boolean isWhite, Checker[][] field) {
        int[] coord = Arrays.stream(str)
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = coord[0];
        int y = coord[1];
        Checker ch = new Checker(x, y, isWhite);
        field[y - 1][x - 1] = ch;
    }

    private static class Checker {
        private static final List<int[]> whiteSteps = List.of(new int[]{-1, 1}, new int[]{1, 1}, new int[]{-1, -1}, new int[]{1, -1});
//        private static final List<int[]> blackSteps = List.of(new int[]{-1, -1}, new int[]{1, -1});
        int x;
        int y;
        boolean isWhite;

        public Checker(int x, int y, boolean isWhite) {
            this.x = x;
            this.y = y;
            this.isWhite = isWhite;
        }

        public boolean isCutDown(Checker[][] field, boolean isWhite) {
            List<int[]> steps = whiteSteps;
//            if (isWhite) {
//                steps = whiteSteps;
//            }
            boolean isCutDown = false;
            for (int[] step : steps) {
                int stepX = x - 1 + step[0];
                int stepY = y - 1 + step[1];

                if (checkIsValidField(field, stepX, stepY) && field[stepY][stepX] != null
                        && field[stepY][stepX].isWhite != this.isWhite) {
                    stepX = stepX + step[0];
                    stepY = stepY + step[1];
                    if (checkIsValidField(field, stepX, stepY) && field[stepY][stepX] == null) {
                        isCutDown = true;
                    }
                }
            }
            return isCutDown;
        }

        private boolean checkIsValidField(Checker[][] field, int x, int y) {
            return x >= 0 && y >= 0 && x < field[0].length && y < field.length;
        }
    }
}
