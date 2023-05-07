package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MinimalRectangle {
    private static int maxX = Integer.MIN_VALUE;
    private static int maxY = Integer.MIN_VALUE;

    private static int minX = Integer.MAX_VALUE;
    private static int minY = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        List<Point> points = new ArrayList<>();

        int x;
        int y;
        while (count != 0) {
            String[] str = reader.readLine().split(" ");
            x = Integer.parseInt(str[0]);
            y = Integer.parseInt(str[1]);
            points.add(new Point(x, y));
            count--;
        }

        points.forEach(p -> {
            maxX = Math.max(maxX, p.getX());
            maxY = Math.max(maxY, p.getY());
            minX = Math.min(minX, p.getX());
            minY = Math.min(minY, p.getY());
        });
        System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
