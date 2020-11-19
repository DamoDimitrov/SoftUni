package JavaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> elements = new ArrayDeque<>();

        Collections.addAll(elements, input);

        while (elements.size() > 1) {
            int numberOne = Integer.parseInt(elements.pop());
            String function = elements.pop();
            int numberTwo = Integer.parseInt(elements.pop());

            switch (function) {
                case "+":
                    elements.push((numberOne + numberTwo) + "");
                    break;
                case "-":
                    elements.push((numberOne - numberTwo) + "");
                    break;
                default:
                    break;
            }
        }
        System.out.println(elements.peek());
    }
}
