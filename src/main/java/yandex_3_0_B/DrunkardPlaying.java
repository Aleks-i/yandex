package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class DrunkardPlaying {
    private static Integer step = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = reader.readLine().split(" ");
        String[] str2 = reader.readLine().split(" ");

        Queue<Integer> playerFirst = getQueue(str1);
        Queue<Integer> playerSecond = getQueue(str2);

        String result = startGame(playerFirst, playerSecond);


        System.out.println(result.equals("botva") ? "botva" :
                result + " " + step);
    }

    private static Queue<Integer> getQueue(String[] str) {
        Queue<Integer> player = new ArrayDeque<>();
        for (String s : str) {
            player.offer(Integer.parseInt(s));
        }
        return player;
    }

    private static String startGame(Queue<Integer> playerFirst, Queue<Integer> playerSecond) {
        while (true) {
            if (playerFirst.isEmpty()) {
                return "second";
            } else if (playerSecond.isEmpty()) {
                return "first";
            }
            int cardFirst = playerFirst.poll();
            int cardSecond = playerSecond.poll();
            if (firstWin(cardFirst, cardSecond)) {
                playerFirst.offer(cardFirst);
                playerFirst.offer(cardSecond);
            } else {
                playerSecond.offer(cardFirst);
                playerSecond.offer(cardSecond);
            }
            step++;
            if (step == 1_000_000) {
                return "botva";
            }
        }
    }

    private static boolean firstWin(int cardFirst, int cardSecond) {
        if (cardFirst == 0 && cardSecond == 9) {
            return true;
        } else if (cardFirst == 9 && cardSecond == 0){
            return false;
        } else {
            return cardFirst > cardSecond;
        }
    }
}
