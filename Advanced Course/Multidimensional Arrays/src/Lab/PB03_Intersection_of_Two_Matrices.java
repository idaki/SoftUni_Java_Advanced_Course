package Lab;

import java.util.Scanner;

public class PB03_Intersection_of_Two_Matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(scanner, rows, cols);
        char[][] secondMatrix = readMatrix(scanner, rows, cols);
        char[][] printMatrix = compareInputMatrices(firstMatrix, secondMatrix, rows, cols);

        printResult(printMatrix);
    }

    private static void printResult(char[][] printMatrix) {
        for (int row = 0; row < printMatrix.length; row++) {
            char[] printArr = printMatrix[row];
            System.out.println(printArr);
        }
    }

    private static char[][] compareInputMatrices(char[][] firstMatrix, char[][] secondMatrix, int rows, int cols) {
        char[][] printMatrix = new char[rows][cols];
        for (int row = 0; row < firstMatrix.length; row++) {
            char[] firstMatrixArr = firstMatrix[row];
            char[] secondMatrixArr = secondMatrix[row];
            char[] printMatrixArr = new char[firstMatrixArr.length];
            for (int col = 0; col < firstMatrixArr.length; col++) {
                if (firstMatrixArr[col] == secondMatrixArr[col]) {
                    printMatrixArr[col] = firstMatrixArr[col];
                } else {
                    printMatrixArr[col] = '*';
                }
            }
            printMatrix[row] = printMatrixArr;
        }
        return printMatrix;
    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            char[] arr = scanner.nextLine().replace("\\s+", "").toCharArray();
            matrix[row] = arr;
        }

        return matrix;

    }
}
