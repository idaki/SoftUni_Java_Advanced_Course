import java.util.Scanner;

public class PB02_Pawn_Wars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = readMatrix(scanner);
        char[] colLetters = {'a', 'b', 'c', 'd', 'e', 'f','g','h'};

        int wRow = getPawnWCoordinates(matrix)[0];
        int wCol = getPawnWCoordinates(matrix)[1];
        int bRow = getPawnBCoordinates(matrix)[0];
        int bCol = getPawnBCoordinates(matrix)[1];

        while (wRow <7 && bRow > 0) {


            wRow++;
            if (wRow ==7){
                char colLetter = colLetters[wCol];
                int rowNumber = wRow + 1;
                System.out.printf("Game over! White pawn is promoted to a queen at %c%d.",colLetter,rowNumber);
                break;
            }
            //check with diagonals
            if (IsOverAfterMovingWhitePawn (matrix, colLetters, wRow, wCol)){
                break;
            }else{
                matrix[wRow][wCol]="w";
                matrix[wRow-1][wCol]="-";
            }
            bRow--;
            if (bRow ==0){
                char colLetter = colLetters[bCol];
                int rowNumber = bRow + 1;
                System.out.printf("Game over! Black pawn is promoted to a queen at %c%d.",colLetter,rowNumber);
                break;
            }

            if (IsOverAfterMovingBlackPawn (matrix, colLetters, bRow, bCol)){
                break;
            }else{
                matrix[bRow][bCol]="b";
                matrix[bRow+1][bCol]="-";
            }




        }




    }

    private static boolean IsOverAfterMovingBlackPawn(String[][] matrix, char[] colLetters, int bRow, int bCol) {

        if (matrix[bRow][bCol - 1].equals("w") && bCol >= 1) {
            char colLetter = colLetters[bCol - 1];
            int rowNumber = bRow + 1;
            System.out.printf("Game over! Black capture on %c%d.", colLetter, rowNumber);
            return true;
        } else if (matrix[bRow][bCol + 1].equals("w") && bCol <= 6) {
            char colLetter = colLetters[bCol + 1];
            int rowNumber = bRow - 1;
            System.out.printf("Game over! White capture on %c%d.", colLetter, rowNumber);
            return true;
        }else
            return false;
    }

    private static boolean IsOverAfterMovingWhitePawn(String[][] matrix, char[] colLetters, int wRow, int wCol) {
        if (matrix[wRow][wCol - 1].equals("b") && wCol >= 1) {
            char colLetter = colLetters[wCol - 1];
            int rowNumber = wRow + 1;
            System.out.printf("Game over! White capture on %c%d.", colLetter, rowNumber);
            return true;
        } else if (matrix[wRow][wCol + 1].equals("b") && wCol <= 6) {
            char colLetter = colLetters[wCol + 1];
            int rowNumber = wRow + 1;
            System.out.printf("Game over! White capture on %c%d.", colLetter, rowNumber);
            return true;
        }
        return false;
    }

    private static int[] getPawnWCoordinates(String[][] matrix) {
        int[] coordinatesMouse = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("w")) {
                    coordinatesMouse[0] = row;
                    coordinatesMouse[1] = col;
                    break;
                }
            }
        }
        return coordinatesMouse;
    }


    private static int[] getPawnBCoordinates(String[][] matrix) {
        int[] coordinatesMouse = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("b")) {
                    coordinatesMouse[0] = row;
                    coordinatesMouse[1] = col;
                    break;
                }
            }
        }
        return coordinatesMouse;
    }

    private static String[][] readMatrix(Scanner scanner) {
        String[][] newMatrix = new String[8][];
        for (int row = 7; row >= 0; row--) {
            newMatrix[row] = scanner.nextLine().split("");
        }
        return newMatrix;
    }
}
