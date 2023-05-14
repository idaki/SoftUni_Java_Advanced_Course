package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PB02_Positions_Of {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int num= Integer.parseInt(scanner.nextLine());
        printResult(matrix, num);


    }

    private static void printResult(int[][] matrix, int num) {
        boolean isExisting= false;
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
            for (int col = 0; col < arr.length ; col++) {
                if (num == matrix[row][col]){
                    System.out.println(row+" "+col);
                    isExisting = true;
                }
            }
        }
        if (!isExisting){
            System.out.println("not found");
        }

    }

    private static int[][] readMatrix(Scanner scanner) {
        String[]  dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows ; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;

        }
        return matrix;

    }

}
