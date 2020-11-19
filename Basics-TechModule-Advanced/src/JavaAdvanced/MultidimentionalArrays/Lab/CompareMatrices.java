package JavaAdvanced.MultidimentionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] collsRowsFirst = scanner.nextLine().split("\\s+");
        int[][] firstMatix = new int[Integer.parseInt(collsRowsFirst[0])][];
        String[] collsRowsSecond = scanner.next().split("\\s+");
        int[][] secondMatrix = new int[Integer.parseInt(collsRowsSecond[0])][];


    }
    static void FillingMatrix(String[] collsRows, int[][] matrix) {
        int rows = Integer.parseInt(collsRows[0]);
        int colls = Integer.parseInt(collsRows[1]);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < colls; c++) {
//                int[] col = Arrays.stream(scanner.nextLine().split)
            }
        }
    }
}
