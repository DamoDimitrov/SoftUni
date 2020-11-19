package JavaAdvanced.MultidimentionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimentions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimentions[0];
        int colls = dimentions[1];
        String[][] matrix = new String[rows][colls];
        for (int r = 0; r < rows; r++) {
            String[] rowNumbers = scanner.nextLine().split("\\s+");
            for (int c = 0; c < colls; c++) {
                matrix[r][c] = rowNumbers[c];
            }
        }
        String checker = scanner.nextLine();
        boolean found = false;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < colls; c++) {
                if(matrix[r][c].equals(checker)) {
                    found = true;
                    System.out.println(r + " " + c);
                }
            }
        }
        if (!found)
            System.out.println("not found");
    }
}
