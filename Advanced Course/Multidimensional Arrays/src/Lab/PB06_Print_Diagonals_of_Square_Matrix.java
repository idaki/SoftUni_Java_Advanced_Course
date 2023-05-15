package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PB06_Print_Diagonals_of_Square_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        printResult(matrix);
    }

    private static void printResult(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
            for (int col = 0; col < arr.length ; col++) {
                if (row==col){
                    System.out.print(arr[col]+" ");
                }
            }
        }
        System.out.println();
        for (int row = matrix.length - 1; row >=0; row--) {
            int[] arr = matrix[row];
            for (int col = arr.length-1; col >= 0 ; col--) {
                if (row+col== matrix.length - 1){
                    System.out.print(arr[col]+" ");
                }
            }
        }
    }
    private static int[][] readMatrix(Scanner scanner) {

        int side = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[side][side];
        for (int row = 0; row < side ; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        return matrix;
    }

}
