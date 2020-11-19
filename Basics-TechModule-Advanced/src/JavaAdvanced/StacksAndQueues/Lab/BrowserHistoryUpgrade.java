package JavaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> url = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();

        while (!"Home".equals(input)) {
            if (!"back".equals(input) && !"forward".equals(input)) {
                url.push(input);
                System.out.println(url.peek());
                forwardPages.clear();
            } else if ("forward".equals(input)) {
                if (forwardPages.isEmpty()) {
                    System.out.println("no next URLs");
                } else
                System.out.println(forwardPages.pop());
            }
            else {
                if (url.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    forwardPages.push(url.pop());
                    System.out.println(url.peek());
                }
            }
            input = scanner.nextLine();
        }
    }
}
