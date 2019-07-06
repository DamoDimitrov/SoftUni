package JavaAdvanced.MultidimentionalArrays.Ex;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] data = sc.nextLine().split(", ");
        int dimentions = Integer.parseInt(data[0]);
        String pattern = data[1];
        int counter = 1;

        int[][] matrix = new int[dimentions][dimentions];
        switch (pattern) {
            case "A":
                for (int rows = 0; rows < dimentions; rows++) {
                    for (int colls = 0; colls < dimentions; colls++) {
                        matrix[colls][rows] = counter;
                        counter++;
                    }
                }
                break;
            case "B":
                for (int colls = 0; colls < dimentions; colls++) {
                    if (colls % 2 == 0) {
                        for (int rows = 0; rows < dimentions; rows++) {
                            matrix[rows][colls] = counter;
                            counter++;
                        }
                    } else {
                        for (int rows = dimentions - 1; rows >= 0; rows--) {
                            matrix[rows][colls] = counter;
                            counter++;
                        }
                    }
                }
                break;
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        int dimentions = matrix.length;
        for (int rows = 0; rows < dimentions; rows++) {
            for (int colls = 0; colls < dimentions; colls++) {
                System.out.print(matrix[rows][colls] + " ");
            }
            System.out.println();
        }
    }
}
