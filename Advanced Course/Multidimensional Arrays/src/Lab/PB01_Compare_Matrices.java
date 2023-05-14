package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PB01_Compare_Matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstMatrix[][] = readMatrix(scanner);
        int secondMatrix[][] = readMatrix(scanner);

        boolean isSame = compareMatrices(firstMatrix, secondMatrix);

        if (isSame) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {

        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] arrFirstMatrix = firstMatrix[row];
            int[] arrSecondMatrix = secondMatrix[row];
            if (arrFirstMatrix.length != arrSecondMatrix.length) {
                return false;
            }
            for (int col = 0; col < arrFirstMatrix.length; col++) {
                int firstElement = arrFirstMatrix[col];
                int secondElement = arrSecondMatrix[col];
                if (firstElement != secondElement) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] readMatrix(Scanner scanner) {
        String[] dimension = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);
        int[][] intMatrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            intMatrix[row] = arr;
        }
        return intMatrix;
    }
}
