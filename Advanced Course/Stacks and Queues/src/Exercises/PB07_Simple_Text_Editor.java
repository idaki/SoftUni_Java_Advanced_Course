package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PB07_Simple_Text_Editor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOps = Integer.parseInt(scanner.nextLine());
        String text = "";
        ArrayDeque<String> history = new ArrayDeque<>();

        for (int i = 0; i < numOps; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(input[0]);

            if (command == 1){
                history.push(text);
                String inputStr= input[1];
                text = String.format(text + inputStr);
            } else if (command == 2) {
                history.push(text);
                int indexToErase = Integer.parseInt(input[1]);
                text = text.substring(0,text.length()-indexToErase);

            }else if (command == 3) {
                int index = Integer.parseInt(input[1]);
                System.out.println(text.charAt(index-1));
            }else if (command == 4) {
                text= history.pop();

            }
        }
    }
}
