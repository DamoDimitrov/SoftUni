package JavaAdvanced.MultidimentionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int colls = scanner.nextInt();
        scanner.nextLine();

        char[][] firstMatrix = new char[rows][colls];
        char[][] secondMatrix = new char[rows][colls];
        char[][] outputMatrix = new char[rows][colls];
        char[] rowChars;
        for (int i = 0; i < rows; i++) {
            rowChars = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            fillMatrices(firstMatrix, i, rowChars.length, rowChars);
        }
        for (int i = 0; i < rows; i++) {
            rowChars = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            fillMatrices(secondMatrix, i, rowChars.length, rowChars);

        }

        intersectMatrices(firstMatrix, secondMatrix, outputMatrix);
        for (int i = 0; i < outputMatrix.length; i++) {
            int rowLenth = outputMatrix[i].length;
            for (int j = 0; j < rowLenth; j++) {
                System.out.print(outputMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static char[][] intersectMatrices(char firstMatrix[][], char secondMatrix[][], char outputMatrix[][]) {
        for (int i = 0; i < firstMatrix.length; i++) {
            int rowLength = firstMatrix[i].length;
            for (int j = 0; j < rowLength; j++) {
                if (firstMatrix[i][j] == secondMatrix[i][j]) {
                    outputMatrix[i][j] = firstMatrix[i][j];
                } else {
                    outputMatrix[i][j] = '*';
                }
            }

        }
        return outputMatrix;
    }

    static void fillMatrices(char[][] matrix, int row, int colls, char[] rowChars) {
        for (int c = 0; c < colls; c++) {
            matrix[row][c] = rowChars[c];
        }
    }
}
