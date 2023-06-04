import java.util.Scanner;

public class PB02_Throne_Conquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        String[][] matrix = readMatrix(scanner);
        int[] parisIndices = getParisCoordinates(matrix);
        int parisCurrentRowIndex = parisIndices[0];
        int parisCurrentColIndex = parisIndices[1];

        while (energy > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String direction = tokens[0];
            int parisNewRowIndex = getNewRowIndex(direction, parisCurrentRowIndex);
            int parisNewColIndex = getNewColIndex(direction, parisCurrentColIndex);
            int spartanRowIndex = Integer.parseInt(tokens[1]);
            int spartanColIndex = Integer.parseInt(tokens[2]);

            if (isInRange(matrix,spartanRowIndex,spartanColIndex)){
                matrix[spartanRowIndex][spartanColIndex] ="S";
            }
            if (!isInRange(matrix, parisNewRowIndex, parisNewColIndex)) {
                energy--;
                continue;
            }

            energy--;
            if (matrix[parisNewRowIndex][parisNewColIndex].equals("H")){
                matrix[parisNewRowIndex][parisNewColIndex] = "-";
                matrix[parisCurrentRowIndex][parisCurrentColIndex] = "-";
              break;
            }else if  (matrix[parisNewRowIndex][parisNewColIndex].equals("S")){
                energy-=2;
                if (energy<=0){
                    matrix[parisCurrentRowIndex][parisCurrentColIndex] = "-";
                    parisCurrentRowIndex = parisNewRowIndex;
                    parisCurrentColIndex = parisNewColIndex;
                    matrix[parisNewRowIndex][parisNewColIndex]="X";



                    break;
                }
            }

            matrix[parisCurrentRowIndex][parisCurrentColIndex] = "-";
            if (energy>0){
            matrix[parisNewRowIndex][parisNewColIndex] = "P";
            } else {
                matrix[parisNewRowIndex][parisNewColIndex] = "X";

            }
            parisCurrentRowIndex = parisNewRowIndex;
            parisCurrentColIndex = parisNewColIndex;
        }

printResult(matrix,parisCurrentRowIndex,parisCurrentColIndex,energy);

    }

    private static void printResult(String[][] matrix, int rowPrint, int colPrint, int energy) {
        if (energy>0){
            System.out.println("Paris has successfully abducted Helen! Energy left: "+energy);
        } else{
            System.out.printf("Paris died at %d;%d.%n",rowPrint,colPrint);
        }


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int getNewRowIndex(String direction, int currentIndex) {
       int newIndex = currentIndex;
        if ("up".equals(direction)){
            newIndex-=1;
        }else if("down".equals(direction)){
            newIndex+=1;
        }
    return newIndex;
    }

    private static int getNewColIndex(String direction, int currentIndex) {
        int newIndex = currentIndex;
        if ("left".equals(direction)){
            newIndex-=1;
        }else if("right".equals(direction)){
            newIndex+=1;
        }
        return newIndex;
    }


    private static boolean isInRange(String[][] matrix, int parisNewRowIndex, int parisNewColIndex) {
        if ((parisNewRowIndex >= 0 && parisNewRowIndex < matrix.length)
                && (parisNewColIndex >= 0 && parisNewColIndex < matrix.length)) {
            return true;
        }
        return false;
    }


    private static int[] getParisCoordinates(String[][] matrix) {
        int[] coordinatesMouse = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("P")) {
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
