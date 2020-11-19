package JavaAdvanced.MultidimentionalArrays.Ex;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] data = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = data[0];
        int colls= data[1];

        String[][] matrix = new String[rows][colls];

            String str = "";
        int row = 0;
        int coll = 0;
            for (int i = 'a'; i < 'a' + rows; i++) {
                for (int j = i; j < i + colls; j++) {
                    matrix[row][coll] = generateString(((char) i), ((char) j));
                    coll++;
                }
                row++;
                coll = 0;
            }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int rowLen = matrix[i].length;
            for (int j = 0; j < rowLen; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String generateString(char rows, char colls) {
        String str = "";
        char first = rows;
        char second = colls;
        char third = rows;
        str = String.valueOf(first)
                + String.valueOf(second)
                + String.valueOf(third);
        return str;
    }
}
