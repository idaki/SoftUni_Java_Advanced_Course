package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class PB03_Diagonal_Difference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sideSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[sideSize][sideSize];
        matrix = readMatrix(scanner, matrix);
        System.out.println();
        int primarySum = sumPrimaryDiagonal(matrix);
        int secondarySum = sumSecondaryDiagonal(matrix);
        System.out.println(Math.abs(primarySum - secondarySum));
    }

    private static int sumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row + col == matrix.length - 1) {
                    sum += matrix[row][col];
                }

            }

        }

        return sum;
    }

    private static int sumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }

            }
        }


        return sum;

    }

    private static int[][] readMatrix(Scanner scanner, int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;

        }
        return matrix;

    }
}
