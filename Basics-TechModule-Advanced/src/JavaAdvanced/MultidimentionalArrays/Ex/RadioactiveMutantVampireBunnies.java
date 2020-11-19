package JavaAdvanced.MultidimentionalArrays.Ex;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimentions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimentions[0];
        int colls = dimentions[1];

        char[][] matrix = new char[rows][];
        fillMatrix(sc, rows, matrix);

        Deque<int[]> bunniesCoordinates = new ArrayDeque<>();

        char[] commands = sc.nextLine().toCharArray();

        boolean isPlayerAlive = true;
        boolean isPlayerInLair = true;

        int[] playerCoordinates1 = playerCoordinates(rows, colls, matrix);
        for (int i = 0; i < commands.length; i++) {
            gettingBunnyCoordinates(rows, colls, matrix, bunniesCoordinates);
            String command = String.valueOf(commands[i]);
            switch (command) {
                case "U":
                    if (playerCoordinates1[0] - 1 >= 0) {
                        if (matrix[playerCoordinates1[0] - 1][playerCoordinates1[1]] != 'B') {
                            matrix[playerCoordinates1[0] - 1][playerCoordinates1[1]] = 'P';
                            matrix[playerCoordinates1[0]][playerCoordinates1[1]] = '.';
                            playerCoordinates1[0]--;
                        } else {
                            isPlayerAlive = false;
                            matrix[playerCoordinates1[0]][playerCoordinates1[1]] = '.';
                            playerCoordinates1[0]--;
                        }
                    } else {
                        isPlayerInLair = false;
                        matrix[playerCoordinates1[0]][playerCoordinates1[1]] = '.';
                    }
                    break;
                case "D":
                    if (playerCoordinates1[0] + 1 < rows) {
                        if (matrix[playerCoordinates1[0] + 1][playerCoordinates1[1]] != 'B') {
                            matrix[playerCoordinates1[0] + 1][playerCoordinates1[1]] = 'P';
                            matrix[playerCoordinates1[0]][playerCoordinates1[1]] = '.';
                            playerCoordinates1[0]++;
                        } else {
                            isPlayerAlive = false;
                            matrix[playerCoordinates1[0]][playerCoordinates1[1]] = '.';
                            playerCoordinates1[0]++;
                        }
                    } else {
                        isPlayerInLair = false;
                        matrix[playerCoordinates1[0]][playerCoordinates1[1]] = '.';
                    }
                    break;
                case "L":
                    if (playerCoordinates1[1] - 1 >= 0) {
                        if (matrix[playerCoordinates1[0]][playerCoordinates1[1] - 1] != 'B') {
                            matrix[playerCoordinates1[0]][playerCoordinates1[1] - 1] = 'P';
                            matrix[playerCoordinates1[0]][playerCoordinates1[1]] = '.';
                            playerCoordinates1[1]--;
                        } else {
                            isPlayerAlive = false;
                            matrix[playerCoordinates1[0]][playerCoordinates1[1]] = '.';
                            playerCoordinates1[1]--;
                        }
                    } else {
                        isPlayerInLair = false;
                        matrix[playerCoordinates1[0]][playerCoordinates1[1]] = '.';
                    }
                    break;
                case "R":
                    if (playerCoordinates1[1] + 1 < colls) {
                        if (matrix[playerCoordinates1[0]][playerCoordinates1[1] + 1] != 'B') {
                            matrix[playerCoordinates1[0]][playerCoordinates1[1] + 1] = 'P';
                            matrix[playerCoordinates1[0]][playerCoordinates1[1]] = '.';
                            playerCoordinates1[1]++;
                        } else {
                            isPlayerAlive = false;
                            matrix[playerCoordinates1[0]][playerCoordinates1[1]] = '.';
                            playerCoordinates1[0]++;
                        }
                    } else {
                        isPlayerInLair = false;
                        matrix[playerCoordinates1[0]][playerCoordinates1[1]] = '.';
                    }
                    break;
            }
            if (multiplyingBunnies(rows, colls, matrix, bunniesCoordinates))
                isPlayerAlive = false;

            if (!isPlayerInLair) {
                printLair(matrix, rows, colls);
                System.out.println(String.format("won: %d %d", playerCoordinates1[0], playerCoordinates1[1]));
                break;
            } else if (!isPlayerAlive) {
                printLair(matrix, rows, colls);
                System.out.println(String.format("dead: %d %d", playerCoordinates1[0], playerCoordinates1[1]));
                break;
            }
        }
    }

    private static void printLair(char[][] matrix, int rows, int colls) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colls; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean multiplyingBunnies(int rows, int colls, char[][] matrix, Deque<int[]> bunniesCoordinates) {
        boolean bunnyOnPlayer = false;
        outter:
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < colls; c++) {
                if (!bunniesCoordinates.isEmpty()) {
                    int row = bunniesCoordinates.peek()[0];
                    int coll = bunniesCoordinates.peek()[1];
                    if (r == row && c == coll) {
                        bunniesCoordinates.poll();
                        if (r > 0)
                            if (matrix[r - 1][c] == 'P') {
                                bunnyOnPlayer = true;
                                break outter;
                            } else
                                matrix[r - 1][c] = 'B';
                        if (r < rows - 1)
                            if (matrix[r + 1][c] == 'P') {
                                bunnyOnPlayer = true;
                                break outter;
                            } else
                                matrix[r + 1][c] = 'B';
                        if (c > 0)
                            if (matrix[r][c - 1] == 'P') {
                                bunnyOnPlayer = true;
                                break outter;
                            } else
                                matrix[r][c - 1] = 'B';
                        if (c < colls - 1)
                            if (matrix[r][c + 1] == 'P') {
                                bunnyOnPlayer = true;
                                break outter;
                            } else
                                matrix[r][c + 1] = 'B';
                    }
                }
            }
        }
        return bunnyOnPlayer;
    }

    private static void gettingBunnyCoordinates(int rows, int colls, char[][] matrix, Deque<int[]> bunniesCoordinates) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < colls; c++) {
                int[] bunnyCordArr = new int[2];
                if (matrix[r][c] == 'B') {
                    bunnyCordArr[0] = r;
                    bunnyCordArr[1] = c;
                    bunniesCoordinates.offer(bunnyCordArr);
                }
            }
        }
    }

    private static int[] playerCoordinates(int rows, int colls, char[][] matrix) {
        int[] playerCoordinates = new int[2];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < colls; c++) {
                if (matrix[r][c] == 'P') {
                    playerCoordinates[0] = r;
                    playerCoordinates[1] = c;
                }
            }
        }
        return playerCoordinates;
    }

    private static void fillMatrix(Scanner sc, int rows, char[][] matrix) {
        for (int i = 0; i < rows; i++) {
            char[] collData = sc.nextLine().toCharArray();
            matrix[i] = collData;
        }
    }
}
