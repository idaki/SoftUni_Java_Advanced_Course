import java.util.Arrays;
import java.util.Scanner;

public class PB02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = readMatrix(scanner);
        int[] mouseCoordinates = getTargetCoordinates(matrix);
        int row = mouseCoordinates[0];
        int col = mouseCoordinates[1];
        boolean isOverBound = false;
        boolean isTrapped = false;
        boolean isLastCheese = false;
        int cheeseTarget = getCheeseTarget(matrix);

        String command = "";
        while (!"danger".equals(command = scanner.nextLine())) {
            int[] newCoordinates = getCoordinatesAfterCommand(command, row, col);
            int newRow = newCoordinates[0];
            int newCol = newCoordinates[1];
            matrix[row][col]="*";
            if (!isValidBound(matrix, newRow, newCol)) {
                matrix[row][col] = "M";
                isOverBound = true;
                break;
            }


            if (matrix[newRow][newCol].equals("C")) {
                cheeseTarget--;
                row = newRow;
                col = newCol;
                matrix[row][col] = "M";
                if (cheeseTarget == 0) {
                    isLastCheese = true;
                    break;
                }
            } else if (matrix[newRow][newCol].equals("@")) {
                matrix[row][col] = "M";
                continue;
            } else if (matrix[newRow][newCol].equals("T")) {
                row = newRow;
                col = newCol;
                matrix[row][col] = "M";
                isTrapped = true;
                break;
            }else if (matrix[newRow][newCol].equals("*")) {
                row = newRow;
                col = newCol;
                matrix[row][col] = "M";
            }
        }

        if (isOverBound){
            System.out.println("No more cheese for tonight!");
        } else if(isLastCheese){
            System.out.println("Happy mouse! All the cheese is eaten, good night!");
        } else if (isTrapped) {
            System.out.println("Mouse is trapped!");
        }else {
            System.out.println("Mouse will come back later!");
        }
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


    private static int getCheeseTarget(String[][] matrix) {
        int cheeseTarget = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col].equals("C")) {
                    cheeseTarget++;
                }
            }
        }
        return cheeseTarget;
    }


    private static boolean isValidBound(String[][] matrix, int row, int col) {
        if (row < 0 || row > matrix.length - 1 || col < 0 || col > matrix[row].length - 1) {
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

                if (matrix[row][col].equals("M")) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }
        return coordinates;
    }

    private static String[][] readMatrix(Scanner scanner) {
        int[] arrayInput = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = arrayInput[0];
        int m = arrayInput[1];

        String[][] newMatrix = new String[n][];
        for (int row = 0; row < n; row++) {
            newMatrix[row] = scanner.nextLine().split("");
        }
        return newMatrix;
    }

}