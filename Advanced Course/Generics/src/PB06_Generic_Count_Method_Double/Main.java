package PB06_Generic_Count_Method_Double;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> list = new Box();
        for (int i = 0; i < n; i++) {
            list.getList().add(Double.parseDouble(scanner.nextLine()));
        }


        System.out.println(list.countGreaterItems(Double.valueOf(scanner.nextLine())));

    }
}
