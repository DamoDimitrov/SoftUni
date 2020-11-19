package JavaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        if (decimalNumber == 0) {
            System.out.println(decimalNumber);
        } else {
            while (decimalNumber != 0) {
                binaryNumber.push(decimalNumber % 2);
                decimalNumber /= 2 ;
            }
        }
        for (Integer bin:binaryNumber) {
            System.out.print(bin);
        }
    }
}
