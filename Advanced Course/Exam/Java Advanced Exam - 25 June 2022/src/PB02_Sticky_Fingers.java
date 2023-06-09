import java.util.Arrays;
import java.util.Scanner;

public class PB02_Sticky_Fingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] matrix = readMatrix(scanner, n);
        int[] drillerCoordinates = getTargetCoordinates(matrix);
        int row = drillerCoordinates[0];
        int col = drillerCoordinates[1];
        int pocket = 0;
        boolean isCaught = false;
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            int newRow = getCoordinatesAfterCommand(command, row, col)[0];
            int newCol = getCoordinatesAfterCommand(command, row, col)[1];
            matrix[row][col] = "+";
            if (isValidBound(matrix, newRow, newCol)) {
                row = newRow;
                col = newCol;
            } else {
                matrix[row][col] = "D";
                System.out.println("You cannot leave the town, there is police outside!");
            }

            if (matrix[row][col].equals("$")) {
                int currentSteal = row * col;
                pocket += currentSteal;
                System.out.printf("You successfully stole %d$.%n", currentSteal);
            } else if ((matrix[row][col].equals("P"))) {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", pocket);
                matrix[row][col] = "#";
                isCaught = true;
                break;
            }

            matrix[row][col] = "D";


        }

        if (!isCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", pocket);
        }
        printResult(matrix, pocket);
    }

    private static void printResult(String[][] matrix, int pocket) {

        for (int row = 0; row < matrix.length; row++) {
            String[] rowArr = matrix[row];
            System.out.println(Arrays.toString(rowArr).replaceAll("[\\[\\],]", ""));
        }

    }

    private static boolean isValidBound(String[][] matrix, int row, int col) {
        if (row < 0 || row > matrix.length - 1 || col < 0 || col > matrix.length - 1) {
            return false;
        }
        return true;
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

    private static int[] getTargetCoordinates(String[][] matrix) {
        int[] coordinates = new int[2];

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col].equals("D")) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }
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
