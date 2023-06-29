package PB02_Point_in_Rectangle_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinatesInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point bottomLeftCorner = new Point(coordinatesInput[0],coordinatesInput[1] );
        Point topRightCornet = new Point( coordinatesInput[2],coordinatesInput[3] );
        Rectangle rectangle = new Rectangle(bottomLeftCorner,topRightCornet);


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] testCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Point testPoint = new Point(testCoordinates[0],testCoordinates[1]);
            System.out.println(rectangle.contains(testPoint));

        }
    }
}
