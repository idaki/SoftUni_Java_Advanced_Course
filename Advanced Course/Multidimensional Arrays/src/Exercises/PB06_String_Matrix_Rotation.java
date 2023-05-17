package Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PB06_String_Matrix_Rotation {
    private static int rows;
    private static int cols;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rotations = calculateRotations(scanner);
        List<String> inputList = new ArrayList<>();
        inputList = readUserInput(scanner, inputList);
        cols = getColsSize(inputList);
        char[][] matrix = fillMatrix(inputList);
        if (rotations == 1 ) {
            char[][] matrixRotated90 = rotateMatrix90(matrix);
            printResult(matrixRotated90);
        } else if (rotations==2) {
            char[][] matrixRotated180 = rotateMatrix180(matrix);
            printResult(matrixRotated180);
        } else if (rotations==3) {
           char[][] matrixRotated270 = rotateMatrix270(matrix);
            printResult(matrixRotated270);
        }else{
            printResult(matrix);
        }


    }

    private static void printResult(char[][] matrix) {
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();

        }
    }

    private static int calculateRotations(Scanner scanner) {
        int rotations = 0;

        int rotationDegree = 0;
        String regex = "(?<degree>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scanner.nextLine());

        while (matcher.find()) {
            rotationDegree = Integer.parseInt(matcher.group("degree"));
        }
        while (rotationDegree>360){
            rotationDegree-=360;
        }
        if (rotationDegree != 0) {
            rotations = rotationDegree / 90;
        } else {
            rotations = 0;
        }
        return rotations;
    }

    private static char[][] rotateMatrix90(char[][] matrix) {

        int newCols = rows;
        int newRows = cols;

        char[][] matrixRotated = new char[newRows][newCols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char current = matrix[row][col];
                matrixRotated[col][newCols - 1] = current;
            }
            newCols--;
        }
        return matrixRotated;
    }

    private static char[][] rotateMatrix180(char[][] matrix) {
        char[][] matrixRotated = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char current = matrix[row][col];
                matrixRotated[rows - 1 - row][cols - 1 - col] = current;
            }
        }
        return matrixRotated;
    }

    private static char[][] rotateMatrix270(char[][] matrix) {
        int newCols = rows;
        int newRows = cols;

        char[][] matrixRotated = new char[newRows][newCols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char current = matrix[row][col];
                matrixRotated[cols-1-col][row] = current;
            }
        }
        return matrixRotated;
    }

    private static char[][] fillMatrix(List<String> inputList) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            char[] rowArr = inputList.get(row).toCharArray();
            for (int i = 0; i < cols; i++) {
                if (i < rowArr.length) {
                    matrix[row][i] = (char) rowArr[i];
                } else {
                    matrix[row][i] = ' ';
                }
            }
        }

        return matrix;
    }


    private static int getColsSize(List<String> inputList) {
        return inputList
                .stream()
                .map(String::length)
                .max(Integer::compare)
                .get();
    }


    private static List<String> readUserInput(Scanner scanner, List<String> inputList) {
        rows = 0;
        String input = "";

        while (!"END".equals(input = scanner.nextLine())) {
            rows++;
            inputList.add(input);
        }
        return inputList;
    }
}
