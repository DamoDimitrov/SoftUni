package JavaAdvanced.StacksAndQueues.Ex;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");

        String[] robots = new String[input.length];
        int[] productionTimeRobots = new int[input.length];
        int[] workingTime = new int[input.length];
        ArrayDeque<String> products = new ArrayDeque<>();
        String beginTime = scanner.nextLine();


        InputRobotsAndTime(input, robots, productionTimeRobots);
        int startingWorkTime = ChangingStartingTime(beginTime);

        String product = scanner.nextLine();
        while (!"End".equals(product)) {
            products.offer(product);

            product = scanner.nextLine();
        }
        while (!products.isEmpty()) {
            startingWorkTime++;
            boolean isAvailable = false;
            String productToChange = products.poll();

            for (int i = 0; i < robots.length; i++) {
                if (workingTime[i] == 0 && !isAvailable) {
                    workingTime[i] = productionTimeRobots[i];
                    String robotName = robots[i];
                    String workTime = ChangingStartingProductionTime(startingWorkTime);
                    PrintingTheResult(workTime, robotName, productToChange);
                    isAvailable = true;
                    break;
                }
            }
            if (!isAvailable) {
                products.offer(productToChange);
            }
            for (int i = 0; i < workingTime.length; i++) {
                if (workingTime[i] != 0)
                    workingTime[i]--;
            }
        }
        System.out.println();
    }

    private static int ChangingStartingTime(String beginTime) {
        String[] beginTimeArray = beginTime.split(":");
        int lineTime = Integer.parseInt(beginTimeArray[0]) * 3600
                + Integer.parseInt(beginTimeArray[1]) * 60
                + Integer.parseInt(beginTimeArray[2]);
        return lineTime;
    }

    private static void InputRobotsAndTime(String[] input, String[] robots, int[] productionTimeRobots) {
        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split("-");
            String robotName = data[0];
            int robotProductionTime = Integer.parseInt(data[1]);

            robots[i] = robotName;
            productionTimeRobots[i] = robotProductionTime;
        }
    }

    private static void PrintingTheResult(String workTime, String robotName, String productName) {
        System.out.println(String.format("%s - %s [%s]", robotName, productName, workTime));
    }

    private static String ChangingStartingProductionTime(int startingWorkTime) {
        String time = "";

        int[] hms = new int[3];

            hms[0] = startingWorkTime / 3600;
            hms[1] = (startingWorkTime - (hms[0] * 3600)) / 60;
            hms[2] = startingWorkTime - ((hms[0] * 3600) + hms[1] * 60);

        time = String.format("%02d:%02d:%02d" , hms[0], hms[1], hms[2]);


        return time;
    }
}
