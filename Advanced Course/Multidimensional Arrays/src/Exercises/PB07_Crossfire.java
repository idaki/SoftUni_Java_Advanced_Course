package Exercises;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PB07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];
        matrix = fillMatrix(matrix, rows, cols);

        String command = "";

        while (!"Nuke it from orbit".equals(command = scanner.nextLine())) {
            int[] commandArr = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix = updateMatrix(commandArr, matrix);

        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length ; row++) {
            int[] arr = matrix[row];
            System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]",""));

        }
    }

    private static int[][] updateMatrix(int[] commandArr, int[][] matrix) {
        int rowAttack = commandArr[0];
        int colAttack = commandArr[1];
        int radiusAttack = commandArr[2];



if (( isValid(rowAttack,colAttack, radiusAttack, matrix))) {
    matrix = removeVerticalIndices(matrix, rowAttack, colAttack, radiusAttack);
    matrix = removeHorizontalIndices(matrix, rowAttack, colAttack, radiusAttack);

}

        return matrix;

    }

    private static boolean isValid(int rowAttack, int colAttack, int radiusAttack, int[][] matrix) {
       if( row >= 0 && row < matrix.size() &&
                col >= 0 && col < matrix.get(row).size()){
            return false;

        }
        return true;
    }


    private static int[][] removeHorizontalIndices(int[][] matrix, int rowAttack, int colAttack, int radiusAttack) {

if (rowAttack<= matrix.length) {
    List<Integer> colList = IntStream.of(matrix[rowAttack])
            .boxed()
            .collect(Collectors.toList());


    int count = 0;

    for (int col = 0; col < matrix[rowAttack].length; col++) {



            if ((col >= colAttack - radiusAttack) && (col <= colAttack + radiusAttack)) {
                colList.remove(col - count);
                count++;
            }

    }

    matrix[rowAttack] = colList.stream().mapToInt(i -> i).toArray();

}
        return matrix;

    }

    private static int[][] removeVerticalIndices(int[][] matrix, int rowAttack, int colAttack, int radiusAttack) {
        for (int row = 0; row < matrix.length; row++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                rowList.add(current);
                if (row < rowAttack) {
                    matrix[row] = removeVerticalLowerIndices(matrix, rowAttack
                            , colAttack, radiusAttack, row, rowList, col);

                } else if (row > rowAttack) {
                    removeVerticalHigherIndices(matrix, rowAttack,
                            colAttack, radiusAttack, row, rowList, col);
                }
            }
        }
        return matrix;
    }

    private static void removeVerticalHigherIndices(int[][] matrix, int rowAttack, int colAttack, int radiusAttack, int row, ArrayList<Integer> rowList, int col) {
        if ((rowAttack + radiusAttack >= row) && (col == colAttack)) {
            rowList.remove(col);
        }
        if (col == matrix[row].length - 1) {
            matrix[row] = rowList.stream().mapToInt(i -> i).toArray();
        }
    }

    private static int[] removeVerticalLowerIndices(int[][] matrix, int rowAttack,
                                                    int colAttack, int radiusAttack,
                                                    int row, ArrayList<Integer> rowList, int col) {
        if ((row<=rowAttack+radiusAttack) && (row>=rowAttack-radiusAttack) && (col == colAttack)) {
            rowList.remove(col);
        }
        if (col == matrix[row].length - 1) {
            matrix[row] = rowList.stream().mapToInt(i -> i).toArray();
        }
        return matrix[row];
    }

    private static int[][] fillMatrix(int[][] matrix, int rows, int cols) {
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                count++;
                matrix[row][col] = count;
            }


        }
        return matrix;
    }
}
