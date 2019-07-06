package DemoExamJuneJA;

import java.util.Map;
import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        char[][] garden = new char[rows][];
        int harvestedCarrots = 0;
        int harvestedPotatoes = 0;
        int harvestedLetuce = 0;
        int harmedVegetables = 0;

        for (int r = 0; r < rows; r++) {
            garden[r] = sc.nextLine().replaceAll(" ", "").toCharArray();
        }
        String command = sc.nextLine();
        while (!command.equals("End of Harvest")) {
            String[] tokens = command.split("\\s+");
            command = tokens[0];
            switch (command) {
                case "Harvest":
                    int row = Integer.parseInt(tokens[1]);
                    int coll = Integer.parseInt(tokens[2]);
                    if (row < rows && coll < garden[row].length) {
                        if (garden[row][coll] != 'M' || garden[row][coll] != ' ') {
                            switch (garden[row][coll]) {
                                case 'C':
                                    harvestedCarrots++;
                                    break;
                                case 'P':
                                    harvestedPotatoes++;
                                    break;
                                case 'L':
                                    harvestedLetuce++;
                                    break;
                            }
                            garden[row][coll] = ' ';
                        }
                    }
                    break;
                case "Mole":
                    row = Integer.parseInt(tokens[1]);
                    coll = Integer.parseInt(tokens[2]);
                    String direction = tokens[3];
                    if (row < rows && coll < garden[row].length) {
                        harmedVegetables = moleMoving(garden, row, coll, direction, harmedVegetables);
                    }
                    break;
            }
            command = sc.nextLine();
        }
        printMatrix(garden);
        printHarvest(harmedVegetables, harvestedCarrots, harvestedLetuce, harvestedPotatoes);
    }

    private static void printHarvest(int harmedVegetables, int harvestedCarrots, int harvestedLetuce, int harvestedPotatoes) {
        System.out.println(String.format("Carrots: %d%n" +
                "Potatoes: %d%n" +
                "Lettuce: %d%n" +
                "Harmed vegetables: %d", harvestedCarrots, harvestedPotatoes, harvestedLetuce, harmedVegetables));
    }

    private static void printMatrix(char[][] garden) {
        for (int r = 0; r < garden.length; r++) {
            for (int c = 0; c < garden[r].length; c++) {
                System.out.print(garden[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static int moleMoving(char[][] garden, int row, int coll, String direction, int harmedVegetables) {
        if (garden[row][coll] != ' ') {
            garden[row][coll] = ' ';
            harmedVegetables++;
        }
        switch (direction) {
            case "up":
                while (row - 2 >= 0) {
                    row -= 2;
                    if (garden[row][coll] != ' ') {
                        garden[row][coll] = ' ';
                    harmedVegetables++;
                }
                }
                break;
            case "down":
                while (row + 2 < garden.length) {
                    row += 2;
                    if (garden[row][coll] != ' ') {
                        garden[row][coll] = ' ';
                        harmedVegetables++;
                    }
                }
                break;
            case "left":
                while (coll - 2 >= 0) {
                    coll -= 2;
                    if (garden[row][coll] != ' ') {
                        garden[row][coll] = ' ';
                        harmedVegetables++;
                    }
                }
                break;
            case "right":
                while (coll + 2 < garden[row].length) {
                    coll += 2;
                    if (garden[row][coll] != ' ') {
                        garden[row][coll] = ' ';
                        harmedVegetables++;
                    }
                }
                break;
        }
        return harmedVegetables;
    }
}
