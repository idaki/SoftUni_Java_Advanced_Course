import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PB02_Treasure_hunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = readMatrix(scanner);

        int[] yCoordinates = getTargetCoordinates(matrix);
        int row = yCoordinates[0];
        int col = yCoordinates[1];
        List<String> pathPrint= new ArrayList<>();
        boolean isFound = false;

        String command = "";

        while (!"Finish".equals(command = scanner.nextLine())) {
            int[] newCoordinates = getCoordinatesAfterCommand(command, row, col);
            matrix[row][col] = "-";
            int newRow = newCoordinates[0];
            int newCol = newCoordinates[1];
            if (isValidBound(matrix, newRow, newCol)) {
                if (!(matrix[newRow][newCol].equals("T"))) {
                    row = newRow;
                    col = newCol;
                } else {
                    matrix[row][col] = "Y";
                    continue;
                }
            } else {
                matrix[row][col] = "Y";
                continue;
            }
            pathPrint.add(command);
            if (matrix[row][col].equals("X")) {
            isFound =true;
            break;
            }
        }
        String path= pathPrint.toString().replaceAll("[\\[\\]]","");
                    if (isFound){
                        System.out.println("I've found the treasure!");
                        System.out.println( "The right path is "+ path);

                    } else{
                        System.out.println("The map is fake!");
                    }

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

                if (matrix[row][col].equals("Y")) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }
        return coordinates;
    }


    private static String[][] readMatrix(Scanner scanner) {
        int[] tokens = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = tokens[0];
        int m = tokens[1];
        String[][] newMatrix = new String[n][];
        for (int row = 0; row < n; row++) {
            newMatrix[row] = scanner.nextLine().split("\\s+");
        }
        return newMatrix;
    }

}
