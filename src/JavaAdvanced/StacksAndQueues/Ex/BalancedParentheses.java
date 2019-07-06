package JavaAdvanced.StacksAndQueues.Ex;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        if (input.length() % 2 != 0)
            System.out.println("NO");
        boolean isBalanced = true;
        ArrayDeque<Character> opening = new ArrayDeque<>();

        for (int i = 0; i < input.length() / 2; i++) {
            opening.push(input.charAt(i));
        }
        for (int i = input.length() / 2; i < input.length(); i++) {
            char last = opening.peek();
            switch (last) {
                case '(':
                    if (input.charAt(i) == ')') {
                        opening.pop();
                        continue;
                    } else
                        isBalanced = false;
                    break;
                case '[':
                    if (input.charAt(i) == ']') {
                        opening.pop();
                        continue;
                    } else
                        isBalanced = false;
                    break;
                case '{':
                    if (input.charAt(i) == '}') {
                        opening.pop();
                        continue;
                    } else
                        isBalanced = false;
                    break;
                default:
                    break;
            }
            if (!isBalanced)
                System.out.println("NO");
            break;

        }
        if (isBalanced)
            System.out.println("YES");
    }
}
