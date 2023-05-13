package LAB;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class PB06_Hot_Potato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        ArrayDeque<String> players = new ArrayDeque<>();
        Collections.addAll(players, names);
        int rounds = Integer.parseInt(scanner.nextLine());

        while (players.size() > 1) {
            String firstPlayer = "";
            for (int i = 1; i < rounds; i++) {
                firstPlayer = players.poll();
                players.offer(firstPlayer);
            }
            System.out.println("Removed " + players.poll());
        }
        System.out.println("Last is " + players.poll());
    }
}
