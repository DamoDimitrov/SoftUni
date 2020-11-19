package JavaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> files = new ArrayDeque<>();

        while (!"print". equals(input)) {
            if (!"cancel".equals(input)) {
                files.offer(input);
            } else {
                if (files.size() == 0) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println(String.format("Canceled %s", files.pop()));
                }
            }
            input = scanner.nextLine();
        }
        for (String file:files) {
            System.out.println(file);
        }
    }
}
