package PB01_Rhombus_of_Stars_Lab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            printRow(i,n);
        }
        for (int i = n-1; i > 0 ; i--) {
            printRow(i,n);
        }

    }

    private static void printRow(int i, int n) {
        for (int j = i ; n>j ; j++) {
            System.out.print(" ");
        }

        for (int j = 1; j <= i; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
