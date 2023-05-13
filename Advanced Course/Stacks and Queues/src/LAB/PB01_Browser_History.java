package LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PB01_Browser_History {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        ArrayDeque<String> history = new ArrayDeque<>();
        String print = "";

        while (!"Home".equals(input = scanner.nextLine())) {

            if (input.equals("back")) {
                if (!history.isEmpty()) {
                    print = history.pop();
                } else {
                  print ="no previous URLs";
                }
            } else {
               if (!print.equals("")) {
                   history.push(print);
               }
                print = input;
            }
            System.out.println(print);
        }

    }
}
