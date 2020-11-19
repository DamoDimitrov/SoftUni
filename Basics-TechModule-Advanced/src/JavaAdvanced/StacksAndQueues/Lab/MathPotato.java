package JavaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputKids = scanner.nextLine().split("\\s+");
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> circle = new ArrayDeque<>();
        Collections.addAll(circle, inputKids);
        int primeNumber = 1;

        while (circle.size() > 1) {
            for (int i = 1; i <= number; i++) {
                if (isPrimeNumber(primeNumber)) {
                    System.out.println("Removed " + circle.pop());
                } else {
                    String kid = circle.pop();
                    circle.offer(kid);
                    System.out.println("Prime" + circle.peek());
                }
            }

        }
        System.out.println("Last is" + circle.pop());
    }
    public static boolean isPrimeNumber(int i) {
        boolean isPrime = false;
        int factors = 0;
        int j = 1;

        while(j <= i)
        {
            if(i % j == 0)
            {
                factors++;
            }
            j++;
        }
        if (factors == 2)
            isPrime = true;
        return isPrime;
    }
}
