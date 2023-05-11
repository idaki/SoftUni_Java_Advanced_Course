package LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PB04_Matching_Brackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> openIndexes = new ArrayDeque<>();
        for (int i = 0; i <input.length() ; i++) {
            char current = input.charAt(i);
             if (current == '('){
                 openIndexes.push(i);
             }
            if (current == ')'){
               int openIndex = openIndexes.pop();
               int closeIndex = i;
                String print = input.substring(openIndex, closeIndex+1);
                System.out.println(print);

            }
        }

    }
}
