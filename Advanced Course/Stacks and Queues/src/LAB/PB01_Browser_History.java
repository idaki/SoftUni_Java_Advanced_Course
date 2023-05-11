package LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PB01_Browser_History {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        ArrayDeque<String> history = new ArrayDeque<>();
        String current = "";

        while (!"Home".equals(input = scanner.nextLine())) {

            if (input.equals("back")) {
                if (!history.isEmpty()) {
                    current = history.pop();
                } else {
                    System.out.println("no previous URLs");
                    continue;
                }
            } else {
                if (!current.equals("")) {
                    history.push(current);
                }
                current = input;
            }
            System.out.println(current);
        }

    }
}
