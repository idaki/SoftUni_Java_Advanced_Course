import java.util.Scanner;

public class PB02_Rall_yRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        String[][] matrix = readMatrix(scanner, n);

        int row = 0;
        int col = 0;
        int distance = 0;
        boolean isRaceOver = false;
        String command = "";

        while (!"End".equals(command = scanner.nextLine())) {
            matrix[row][col] = ".";
            int[] newCoordinates = getCoordinatesAfterCommand(command, row, col);
            row = newCoordinates[0];
            col = newCoordinates[1];

            if (matrix[row][col].equals("T")) {
                matrix[row][col] = ".";
                newCoordinates = getTunnelExitCoordinates(matrix, row, col);
                row = newCoordinates[0];
                col = newCoordinates[1];
                matrix[row][col] = racingNumber;
                distance += 30;
            } else if (matrix[row][col].equals("F")) {
                distance += 10;
                isRaceOver = true;
                break;
            } else {
                matrix[row][col] = racingNumber;
                distance += 10;
            }
        }
        matrix[row][col] = "C";

        if (isRaceOver) {
            System.out.printf("Racing car %s finished the stage!%n", racingNumber);
        } else {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }
        System.out.printf("Distance covered %d km.%n", distance);
        printResult(matrix);

    }

    private static void printResult(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }


    private static int[] getTunnelExitCoordinates(String[][] matrix, int currentRow, int currentCol) {
        int[] coordinates = new int[2];

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                if (col == currentRow && row == currentRow) {
                    continue;
                }
                if (matrix[row][col].equals("T")) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }
        return coordinates;
    }


    private static int[] getCoordinatesAfterCommand(String command, int row, int col) {
        int[] coordinates = new int[2];

        if ("up".contains(command)) {
            row--;
        } else if ("down".contains(command)) {
            row++;
        } else if ("left".contains(command)) {
            col--;
        } else if ("right".contains(command)) {
            col++;
        }
        coordinates[0] = row;
        coordinates[1] = col;

        return coordinates;

    }


    private static String[][] readMatrix(Scanner scanner, int n) {

        String[][] newMatrix = new String[n][];
        for (int row = 0; row < n; row++) {
            newMatrix[row] = scanner.nextLine().split("\\s+");
        }
        return newMatrix;
    }


}
