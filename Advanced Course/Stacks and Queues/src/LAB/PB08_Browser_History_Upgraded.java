package LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PB08_Browser_History_Upgraded {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwards = new ArrayDeque<>();
        String print = "";

        while (!"Home".equals(input = scanner.nextLine())) {

            if (input.equals("back")) {
                if (!history.isEmpty()) {
                    forwards.push(print);
                    print = history.pop();
                } else {
                    print = "no previous URLs";
                }
            } else if (input.equals("forward")) {
                if (!forwards.isEmpty()) {
                    print = forwards.pop();
                } else {
                    System.out.println("no next URLs");
                    continue;

                }
            } else {
                if (!print.equals("")) {
                    history.push(print);

                    if (!forwards.isEmpty()) {
                        forwards.clear();
                    }
                }
                print = input;
            }
            System.out.println(print);
        }

    }
}
