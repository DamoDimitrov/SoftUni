package JavaOOP.WorkingWithAbstraction.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rectCoordinates = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int botLX = rectCoordinates[0];
        int botLY = rectCoordinates[1];
        int topRX = rectCoordinates[2];
        int topRY = rectCoordinates[3];

        Point bottomLeft;
        Point topRight;

        Rectangle rectangle = new Rectangle(
                bottomLeft = new Point(botLX, botLY)
                ,topRight = new Point(topRX, topRY));
        int numberOfPoints = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfPoints; i++) {
            int[] pointCoordinates = Arrays.stream(sc.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();
            Point point = new Point(pointCoordinates[0], pointCoordinates[1]);

            System.out.println(rectangle.contains(point));
        }
    }
}
