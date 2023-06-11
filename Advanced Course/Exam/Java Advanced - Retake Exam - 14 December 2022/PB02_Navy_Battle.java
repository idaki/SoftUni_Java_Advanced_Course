import java.util.Scanner;

public class PB02_Navy_Battle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = readMatrix(scanner);
        int[] submarineCoordinates = getTargetCoordinates(matrix);
        int row = submarineCoordinates[0];
        int col = submarineCoordinates[1];
        int mineCount = 0;
        int cruiserCount = 0;

        while (mineCount <= 2 && cruiserCount < 3) {
            String command = scanner.nextLine();
            matrix[row][col] = "-";
            row = getCoordinatesAfterCommand(command, row, col)[0];
            col = getCoordinatesAfterCommand(command, row, col)[1];
            String nextPosition = matrix[row][col];

            if (nextPosition.equals("-")) {
                matrix[row][col] = "S";
            } else if (nextPosition.equals("*")) {
                matrix[row][col] = "-";
                mineCount++;
            } else if (nextPosition.equals("C")) {
                matrix[row][col] = "-";
                cruiserCount++;
            }
        }

        if (cruiserCount >= 3) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        } else if (mineCount > 2) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", row, col);
        }

        matrix[row][col] = "S";

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

                if (matrix[row][col].equals("S")) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }
        return coordinates;
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
