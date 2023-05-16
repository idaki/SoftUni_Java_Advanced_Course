package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class PB02_Matrix_of_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = input[0];
        int cols = input[1];
        String[][] matrix = new String[rows][cols];

        fillInMatrix(matrix, rows, cols);
        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length ; row++) {
            String[] printArr= matrix[row];
            System.out.println(Arrays.toString(printArr).replaceAll("[\\[\\],]",""));
        }
    }

    private static String[][] fillInMatrix(String[][] matrix, int rows, int cols) {
        int count = 0;
        for (int row = 0; row < rows; row++) {
            char lineChar = (char) ('a' + count);
            count++;
            for (int col = 0; col < cols; col++) {
                StringBuilder string = new StringBuilder();

                matrix[row][col] = String.valueOf(createMatrixElement(lineChar, string, col));
            }

        }
        return matrix;
    }

    private static StringBuilder createMatrixElement(char lineChar, StringBuilder string, int col) {
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                string.append((char)(lineChar + col));
            } else {
                string.append(lineChar);
            }
        }
        return string;
    }
}
