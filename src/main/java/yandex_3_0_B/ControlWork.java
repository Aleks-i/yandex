package yandex_3_0_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControlWork {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countStudent = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        int row = Integer.parseInt(reader.readLine());
        int seat = Integer.parseInt(reader.readLine());

        int numberSeatPeter = computeSeat(row, seat);
        int resultNumberSeatBack = computeNearestSeatBack(numberSeatPeter, k);
        int resultNumberSeatFront = computeNearestSeatFront(numberSeatPeter, k);

        if (resultNumberSeatBack > countStudent && resultNumberSeatFront > 0) {
            print(computeRowAndSeat(resultNumberSeatFront));
        } else if (resultNumberSeatBack <= countStudent && resultNumberSeatFront <= 0){
            print(computeRowAndSeat(resultNumberSeatBack));
        } else if (resultNumberSeatBack > countStudent && resultNumberSeatFront <= 0) {
            print(new int[]{-1, 0});
        } else if (isRowBackEqualRowFrontOrSmaller(resultNumberSeatBack, resultNumberSeatFront, numberSeatPeter)){
            print(computeRowAndSeat(resultNumberSeatBack));
        } else {
            print(computeRowAndSeat(resultNumberSeatFront));
        }
    }

    private static int computeSeat(int rowStart, int seatStart) {
        return (rowStart - 1) * 2 + seatStart;
    }

    private static int computeNearestSeatBack(int numberSeat, int countOption) {
        if (countOption == 1) {
            return numberSeat + 2;
        }
        return numberSeat + countOption;
    }

    private static int computeNearestSeatFront(int numberSeat, int countOption) {
        if (countOption == 1) {
            return numberSeat - 2;
        }
        return numberSeat - countOption;
    }

    private static int[] computeRowAndSeat(int resultNumberSeat) {
        int resultRow = resultNumberSeat / 2 + resultNumberSeat % 2;
        int resultSeat = 2 - resultNumberSeat % 2;
        return new int[]{resultRow, resultSeat};
    }

    private static void print(int[] str) {
        int row = str[0];
        int seat = str[1];
        if (row == -1) {
            System.out.println(row);
        } else {
            System.out.println(row + " " + seat);
        }
    }

    private static boolean isRowBackEqualRowFrontOrSmaller(int resultNumberSeatBack, int resultNumberSeatFront, int numberSeatStudent) {
        int rowFront = getRow(resultNumberSeatFront);
        int rowBack = getRow(resultNumberSeatBack);
        int rowStudent = getRow(numberSeatStudent);
        return rowBack - rowStudent <= rowStudent - rowFront;
    }

    private static int getRow(int seat) {
        return seat / 2 + seat % 2;
    }
}
