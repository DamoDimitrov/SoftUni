package JavaAdvanced.StacksAndQueues.Ex;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> normalStack = new ArrayDeque<>();
        ArrayDeque<Integer> ascendingStack = new ArrayDeque<>();

        for (int i = 0; i < countCommands; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "1":
                    int numberToPush = Integer.parseInt(tokens[1]);
                    if (normalStack.isEmpty()) {
                        normalStack.push(numberToPush);
                        ascendingStack.push(numberToPush);
                    } else if (numberToPush > ascendingStack.peek()) {
                        normalStack.push(numberToPush);
                        ascendingStack.push(numberToPush);
                    } else {
                        normalStack.push(numberToPush);
                    }
                    break;
                case "2":
                    if (normalStack.peek() == ascendingStack.peek()) {
                        normalStack.pop();
                        ascendingStack.pop();
                    } else
                        normalStack.pop();
                    break;
                case "3":
                    System.out.println(ascendingStack.peek());
                    break;
                default:
                    break;
            }
        }
    }
}
