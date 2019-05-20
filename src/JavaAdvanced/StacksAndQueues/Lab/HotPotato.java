package JavaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split("\\s+");
        int numberToBurn = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> circleKids = new ArrayDeque<>();
        Collections.addAll(circleKids, kids);

        while (circleKids.size() > 1) {
            for (int i = 1; i <= numberToBurn; i++) {
                if (!(i == numberToBurn)) {
                    String kid = circleKids.pop();
                    circleKids.offer(kid);
                } else {
                    System.out.println("Removed " + circleKids.pop());
                }
            }
        }
        System.out.println("Last is " + circleKids.pop());
    }
}
