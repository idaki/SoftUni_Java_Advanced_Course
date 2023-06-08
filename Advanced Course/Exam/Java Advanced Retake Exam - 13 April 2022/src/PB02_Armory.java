import java.util.Scanner;
import java.util.function.Predicate;

public class PB02_Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = readMatrix(scanner);

        int[] officerCoordinates = getOfficerCoordinates(matrix);
        int goldCoins = 0;
        int row = officerCoordinates[0];
        int col = officerCoordinates[1];

        boolean hasLeftArmory = false;


        while (goldCoins < 65) {
            String command = scanner.nextLine();
            matrix[row][col] = "-";




            if ("up".equals(command)) {
                if (row > 0) {
                    row--;
                } else {
                    hasLeftArmory = true;
                    break;
                }
            } else if ("down".equals(command)) {
                if (row < matrix.length - 1) {
                 row++;

                } else {
                    hasLeftArmory = true;
                    break;
                }
            } else if ("left".equals(command)) {
                if (col > 0) {
                    col--;
                } else {
                    hasLeftArmory = true;
                    break;
                }
            } else if ("right".equals(command)) {
                if (col < matrix.length - 1) {

                    col++;
                } else {
                    hasLeftArmory = true;
                    break;
                }
            }
            if (matrix[row][col].equals("M")) {
                matrix[row][col] = "-";
                int[] newCoordinates = getMirrorCoordinates(matrix, row, col);
                row = newCoordinates[0];
                col = newCoordinates[1];
            } else if (Character.isDigit(matrix[row][col].charAt(0))) {
                int gold = Integer.parseInt(matrix[row][col]);
                goldCoins += gold;
            }
            matrix[row][col] = "A";
        }

        System.out.printf("The king paid %d gold coins.%n", goldCoins);
        printResult(matrix, hasLeftArmory);

    }


    private static void printResult(String[][] matrix, boolean hasLeftArmory) {
        if (hasLeftArmory) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }

    private static int[] getMirrorCoordinates(String[][] matrix, int currentRow, int currentCol) {
        int[] coordinatesMirror = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == currentRow && col == currentCol) {
                    continue;
                }
                if (matrix[row][col].equals("M")) {
                    coordinatesMirror[0] = row;
                    coordinatesMirror[1] = col;
                    break;
                }
            }
        }
        return coordinatesMirror;
    }

    private static int[] getOfficerCoordinates(String[][] matrix) {
        int[] coordinatesOfficer = new int[2];

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col].equals("A")) {
                    coordinatesOfficer[0] = row;
                    coordinatesOfficer[1] = col;
                    break;
                }
            }
        }
        return coordinatesOfficer;
    }

    private static String[][] readMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        String[][] newMatrix = new String[n][];
        for (int row = 0; row < n; row++) {
            newMatrix[row] = scanner.nextLine().split("");
        }
        return newMatrix;
    }


}
