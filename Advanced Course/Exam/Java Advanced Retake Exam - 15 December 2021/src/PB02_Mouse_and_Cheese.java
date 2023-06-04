import java.util.Arrays;
import java.util.Scanner;

public class PB02_Mouse_and_Cheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = readMatrix(scanner);
        int[] coordinatesMouse = getMouseCoordinates(matrix);
        int currentRow = coordinatesMouse[0];
        int currentCol = coordinatesMouse[1];
        String command = "";
        int cheeseCount = 0;
        int countB = 0;

        while (!"end".equals(command = scanner.nextLine())) {


            int rowIndexChange = getRowIndex(command);
            int colIndexChange = getColIndex(command);

            int rowNewIndex = currentRow + rowIndexChange;
            int colNewIndex = currentCol + colIndexChange;

            if (!isInRange(matrix, rowNewIndex, colNewIndex)) {
                System.out.println("Where is the mouse?");
                matrix[currentRow][currentCol] = "-";
                break;
            }

            if ("c".equals(matrix[rowNewIndex][colNewIndex])) {
                cheeseCount++;
            } else if ("B".equals(matrix[rowNewIndex][colNewIndex])) {
                matrix[rowNewIndex][colNewIndex] = "M";
                matrix[currentRow][currentCol] = "-";
                currentRow += rowIndexChange;
                currentCol += colIndexChange;

                rowNewIndex += rowIndexChange;
                colNewIndex += colIndexChange;

                if ("c".equals(matrix[rowNewIndex][colNewIndex])) {
                    cheeseCount++;
                }
            }
            matrix[rowNewIndex][colNewIndex] = "M";
            matrix[currentRow][currentCol] = "-";
            currentRow = rowNewIndex;
            currentCol = colNewIndex;


        }

        printResult(matrix, cheeseCount);


    }

    private static int getRowIndex(String command) {
        int indexChange = 0;
        if ("up".equals(command)) {
            indexChange = -1;
        } else if ("down".equals(command)) {
            indexChange = 1;
        }
        return indexChange;
    }

    private static int getColIndex(String command) {
        int indexChange = 0;
        if ("left".equals(command)) {
            indexChange = -1;
        } else if ("right".equals(command)) {
            indexChange = 1;
        }
        return indexChange;
    }

    private static void printResult(String[][] matrix, int cheeseCount) {
        if (cheeseCount < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseCount);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseCount);
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }

    private static boolean isInRange(String[][] matrix, int newRow, int newCol) {

        if ((newRow >= 0 && newRow < matrix.length)
                && (newCol >= 0 && newCol < matrix.length)) {
            return true;
        }
        return false;
    }


    private static int[] getMouseCoordinates(String[][] matrix) {
        int[] coordinatesMouse = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("M")) {
                    coordinatesMouse[0] = row;
                    coordinatesMouse[1] = col;
                    break;
                }
            }
        }
        return coordinatesMouse;
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