package LAB;

import java.util.*;

public class PB07_Math_Potato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        PriorityQueue<String> players = new PriorityQueue<>(Arrays.asList(names));
        int rounds = Integer.parseInt(scanner.nextLine());
        int cycle = 0;

        while (players.size() > 1) {
            cycle++;
            String firstPlayer = "";
            for (int i = 1; i < rounds; i++) {
                firstPlayer = players.poll();
                players.offer(firstPlayer);
            }
            if (!isPrime(cycle)) {
                System.out.println("Removed " + players.poll());
            } else {
                System.out.println("Prime " + players.peek());
            }
        }
        System.out.println("Last is " + players.poll());
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
