package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PB05_Maximum_Sum_of_2X2_Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = readMatrix(scanner, rows, cols);
        int[][] biggestSubMatrix = getBiggestSubMatrix(matrix);
        printResult(biggestSubMatrix);
    }

    private static void printResult(int[][] biggestSubMatrix) {
        int sum = 0;
        for (int row = 0; row < biggestSubMatrix.length ; row++) {
            int[] arr = biggestSubMatrix[row];
            System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]",""));
            for (int col = 0; col < arr.length; col++) {
                sum+= arr[col];
            }
        }
        System.out.println(sum);
    }

    public static int[][] getBiggestSubMatrix(int[][] matrix) {
        int biggestSubMatrix[][] = new int[2][2];
        int maxSum = 0;
        int currentSum = 0;

        for (int row = 0; row < matrix.length-1 ; row++) {
            int[] arrTopLine = matrix[row];
            int[] arrBottomLine = matrix[row+1];
            for (int col = 0; col < arrTopLine.length-1 ; col++) {
                currentSum = arrTopLine[col]+arrTopLine[col+1]+arrBottomLine[col]+arrBottomLine[col+1];
                if (currentSum>maxSum){
                    maxSum = currentSum;
                    int[] arrTop= {arrTopLine[col],arrTopLine[col+1]};
                    int[] arrBot= {arrBottomLine[col],arrBottomLine[col+1]};
                    biggestSubMatrix[0]= arrTop;
                    biggestSubMatrix[1]= arrBot;
                }
            }
        }
        return biggestSubMatrix;
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
