package PB03_Cards_with_Power;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rankInput = scanner.nextLine();
        String suiteInput = scanner.nextLine();

        Rank rank = Rank.valueOf(rankInput);
        Suite suite = Suite.valueOf(suiteInput);

        int result = rank.getPower()+ suite.getPower();
        System.out.printf("Card name: %s of %s; Card power: %d",rankInput,suiteInput,result);

    }
}
