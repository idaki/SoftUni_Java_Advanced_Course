package PB01_Card_Suit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input + ":");
        for (CardsSuit cardSuit : CardsSuit.values()) {
            System.out.println("Ordinal value: " + cardSuit.ordinal() + "; Name value: " + cardSuit.name());
        }
    }
}
