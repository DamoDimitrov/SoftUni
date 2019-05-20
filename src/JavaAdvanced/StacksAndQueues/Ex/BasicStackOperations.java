package JavaAdvanced.StacksAndQueues.Ex;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int elementsToPush = tokens[0];
        int elementsToDelete = tokens[1];
        int elementToCheck = tokens[2];
        ArrayDeque<Integer> stackWithIntegers = new ArrayDeque<>();
        int[] elements = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < elementsToPush; i++) {
            stackWithIntegers.push(elements[i]);
        }
        for (int i = 0; i < elementsToDelete; i++) {
            stackWithIntegers.pop();
        }
        if (stackWithIntegers.size() == 0) {
            System.out.println("0");
        } else if (stackWithIntegers.contains(elementToCheck)) {
            System.out.println("true");
        } else {
            int smallest = stackWithIntegers.peek();
            for (int i = 0; i < stackWithIntegers.size(); i++) {
                int last = stackWithIntegers.pop();
                stackWithIntegers.push(last);
                if (smallest > stackWithIntegers.peek()) {
                    smallest = stackWithIntegers.peek();
                }
            }
            System.out.println(smallest);
        }
    }
}
