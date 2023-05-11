package LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PB03_Decimal_To_Binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numDec = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numBin = new ArrayDeque<>();

        if (numDec == 0){
            numBin.push(0);
        }

        while (numDec > 0) {
            int binValue = numDec % 2;
            numBin.push(binValue);
            numDec/=2;
        }

        while (!numBin.isEmpty()){
            System.out.print(numBin.pop());
        }
    }
}
