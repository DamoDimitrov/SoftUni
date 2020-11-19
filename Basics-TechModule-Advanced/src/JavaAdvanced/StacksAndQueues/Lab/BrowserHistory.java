package JavaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> url = new ArrayDeque<>();

        while (!"Home".equals(input)) {
            if (!"back".equals(input)) {
                url.push(input);
                System.out.println(url.peek());
            } else {
                if (url.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    url.pop();
                    System.out.println(url.peek());
                }
            }
            input = scanner.nextLine();
        }
    }
}
