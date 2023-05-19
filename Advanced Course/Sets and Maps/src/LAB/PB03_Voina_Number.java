package LAB;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PB03_Voina_Number {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> firstPlayerSet = getCards(scanner);
        LinkedHashSet<Integer> secondPlayerSet = getCards(scanner);

        for (int round = 0; round < 50; round++) {
            if (firstPlayerSet.isEmpty()) {
                System.out.println("Second player win!");
                return;
            }
            if (secondPlayerSet.isEmpty()) {
                System.out.println("First player win!");
                return;
            }
            Integer firstPlayerCard = firstPlayerSet.iterator().next();
            Integer secondPlayerCard = secondPlayerSet.iterator().next();

            firstPlayerSet.remove(firstPlayerCard);
            secondPlayerSet.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerSet.add(firstPlayerCard);
                firstPlayerSet.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerSet.add(firstPlayerCard);
                secondPlayerSet.add(secondPlayerCard);
            } else {
                firstPlayerSet.add(firstPlayerCard);
                secondPlayerSet.add(secondPlayerCard);
            }
        }


        if (firstPlayerSet.size() > secondPlayerSet.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerSet.size() > firstPlayerSet.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
    private static LinkedHashSet<Integer> getCards (Scanner scanner){


        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        LinkedHashSet<Integer> set = new LinkedHashSet<>(input);

        return set;

    }

}