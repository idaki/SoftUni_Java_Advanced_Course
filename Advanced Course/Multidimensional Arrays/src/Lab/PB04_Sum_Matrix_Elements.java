package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PB04_Sum_Matrix_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = readMatrix(scanner, rows, cols);
        int sum = calculateMatrixSum(matrix);
        printResult(rows, cols, sum);
    }

    private static int calculateMatrixSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
            for (int element : arr) {
                sum += element;
            }
        }
        return sum;
    }

    private static void printResult(int rows, int cols, int sum) {
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        return matrix;
    }
}
