package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PB07_Find_the_Real_Queen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = readMatrix(scanner);
        int arr[] = getRealQueenCoordinates(matrix);

        System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]",""));

    }

    private static int[] getRealQueenCoordinates(char[][] matrix) {
        boolean isRealVertical = true;
        boolean isReaHorizontal = true;
        boolean isRealDiagonalsBackward = true;
        boolean isRealDiagonalsForward = true;

        int[] coordinatesArr = new int[2];

        for (int row = 0; row < 8; row++) {
            char[] arr = matrix[row];
            for (int col = 0; col < 8; col++) {
                if (arr[col] == 'q') {
                    isRealVertical = confirmVertical(row, col, matrix);
                    isReaHorizontal = confirmHorizontal(row, col, matrix);
                    if (isRealVertical & isReaHorizontal) {
                        isRealDiagonalsBackward = isRealDiagonalsBackward(row, col, matrix);
                        isRealDiagonalsForward = isRealDiagonalsForward(row, col, matrix);
                    }
                    if (isRealVertical && isReaHorizontal && isRealDiagonalsBackward && isRealDiagonalsForward) {
                        coordinatesArr= new int[]{row, col};
                    }
                }

            }

        }
        return coordinatesArr;
    }

    private static boolean isRealDiagonalsForward(int row, int col, char[][] matrix) {
        boolean isReal = true;
        if (row == 7) {
            return true;
        }
        int indexIncreasing = col;
        int indexDecreasing = col;

        for (int i = row + 1; i < 8; i++) {
            char[] arr = matrix[i];

            if (indexIncreasing < 7) {
                indexIncreasing++;
                if (arr[indexIncreasing] == 'q') {
                    return false;
                }
                if (indexDecreasing > 0) {
                    indexDecreasing--;
                    if (arr[indexDecreasing] == 'q') {
                        return false;
                    }
                }
            }
        }


        return true;
    }

    private static boolean isRealDiagonalsBackward(int row, int col, char[][] matrix) {
        boolean isReal = true;
        if (row == 8) {
            return true;
        }
        int indexIncreasing = col;
        int indexDecreasing = col;
        for (int i = row - 1; i >= 0; i--) {
            char[] arr = matrix[i];

            if (indexIncreasing < 7) {
                indexIncreasing++;
                if (arr[indexIncreasing] == 'q') {
                    return false;
                }
            }
            if (indexDecreasing > 0) {
                indexDecreasing--;
                if (arr[indexDecreasing] == 'q') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean confirmHorizontal(int row, int col, char[][] matrix) {
        char[] arr = matrix[row];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'q') {
                count++;
            }
        }
        if (count != 1) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean confirmVertical(int row, int col, char[][] matrix) {
        int countRow = 0;
        while (countRow < 8) {
            if (countRow == row) {
                countRow++;
                continue;
            }
            char current = matrix[countRow][col];
            if (current == 'q') {
                return false;
            }
            countRow++;
        }
        return true;
    }

    private static char[][] readMatrix(Scanner scanner) {

        char[][] matrix = new char[8][8];

        for (int row = 0; row < matrix.length; row++) {
            char[] arr = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[row] = arr;
        }
        return matrix;
    }
}
