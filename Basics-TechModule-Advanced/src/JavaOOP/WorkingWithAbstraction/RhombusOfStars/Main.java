package JavaOOP.WorkingWithAbstraction.RhombusOfStars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < input - 1; i++) {
            String row = concatRow(input, i);
            System.out.println(row);
        }
        String midRow = "";
        for (int i = 0; i < input; i++) {
            midRow += "* ";
        }
        System.out.println(midRow);
        for (int i = input - 2; i >= 0; i--) {
            String row = concatRow(input, i);
            System.out.println(row);
        }

    }

    private static String concatRow(int input, int i) {
        String row = "";
        for (int j = input - 1 - i; j > 0; j--) {
            row += " ";
        }
        for (int j = 0; j <= i ; j++) {
            row += "* ";
        }
        return row;
    }
}
