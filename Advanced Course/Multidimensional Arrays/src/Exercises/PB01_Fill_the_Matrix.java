package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class PB01_Fill_the_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");
        int sideSize = Integer.parseInt(input[0]);
        String matrixType = input[1];
        System.out.println();
        int[][] matrix = new int[sideSize][sideSize];
        if (matrixType.equals("A")) {
            fillInMatrixTypeA(matrix);
        } else {
            fillInMatrixTypeB(matrix);
        }
        print(matrix);


    }

    private static void print(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
            System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]",""));

        }
    }

    private static void fillInMatrixTypeB(int[][] matrix) {
        int count = 0;

        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length ; row++) {
                   count++;
                    matrix[row][col]= count;
                }
            }else{
                for (int row = matrix.length-1; row >=0 ; row--) {
                    count++;
                    matrix[row][col]= count;
                }
            }

        }
    }

    private static int[][] fillInMatrixTypeA(int[][] matrix) {
        int count = 0;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                count++;
                matrix[row][col] = count;
            }
        }
        return matrix;
    }
}
