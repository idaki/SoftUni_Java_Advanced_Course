package Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PB07_Hands_of_Cards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        LinkedHashMap<String, LinkedHashMap<String, Integer>> users = new LinkedHashMap<>();

        while (!"JOKER".equals(input= scanner.nextLine())) {
            String[] token = input.split(": ");
            String name = token[0].replace(":", "");
            String[] cards = token[1].split(", ");

            for (int i = 0; i < cards.length; i++) {
                users.putIfAbsent(name, new LinkedHashMap<>());

                users.get(name).putIfAbsent(cards[i], 0);
                int value = getValue(cards, i);
                value = getValueUpdatedByMultiplier(cards, i, value);
                users.get(name).put(cards[i], value);
            }
        }

        printResult(users);

    }

    private static int getValueUpdatedByMultiplier(String[] cards, int i, int value) {
        if (cards[i].endsWith("C")) {
            value *= 1;
        } else if (cards[i].endsWith("H")) {
            value *= 3;
        } else if (cards[i].endsWith("S")) {
            value *= 4;
        } else if (cards[i].endsWith("D")) {
            value *= 2;
        }
        return value;
    }

    private static int getValue(String[] cards, int i) {
        int value;
        if ("J".equals(cards[i].substring(0, cards[i].length() - 1))) {
            value = 11;
        } else if ("Q".equals(cards[i].substring(0, cards[i].length() - 1))) {
            value = 12;
        } else if ("K".equals(cards[i].substring(0, cards[i].length() - 1))) {
            value = 13;
        } else if ("A".equals(cards[i].substring(0, cards[i].length() - 1))) {
            value = 14;
        } else {
            value = (Integer.parseInt(cards[i].substring(0, cards[i].length() - 1)));
        }
        return value;
    }

    private static void printResult(LinkedHashMap<String, LinkedHashMap<String, Integer>> users) {
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            System.out.printf(user.getKey() + ": ");
            int sum = 0;
            for (int x : user.getValue().values()) {
                sum += x;
            }
            System.out.println(sum);
        }
    }

}
