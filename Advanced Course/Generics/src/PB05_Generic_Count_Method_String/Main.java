package PB05_Generic_Count_Method_String;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<String> list = new Box();
        for (int i = 0; i < n; i++) {
            list.getList().add(scanner.nextLine());
        }


        System.out.println(list.countGreaterItems(scanner.nextLine()));

    }
}
