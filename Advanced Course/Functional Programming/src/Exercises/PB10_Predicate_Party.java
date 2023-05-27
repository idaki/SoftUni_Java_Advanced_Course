package Exercises;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PB10_Predicate_Party {


    private static final BiPredicate<String, String> removeStartsWithPredicate = (name, start) -> !name.startsWith(start);

    public static final BiPredicate<String, String> doubleStartsWithPredicate = String::startsWith;

    public static final BiPredicate<String, String> removeEndsWithPredicate = (name, end) -> !name.endsWith(end);

    public static final BiPredicate<String, String> doubleEndsWithPredicate = String::endsWith;

    public static final BiPredicate<String, Integer> removeLengthPredicate = (name, length) -> name.length() != length;

    public static final BiPredicate<String, Integer> doubleLengthPredicate = (name, length) -> name.length() == length;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> guestList = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());

        String commandInput;

        while (!"Party!".equals(commandInput = scanner.nextLine())) {
            String[] commands = commandInput.split("\\s+");

            if ("Remove".equals(commands[0])) {
                guestList = remove(new String[]{commands[1], commands[2]}, guestList);
            } else if ("Double".equals(commands[0])) {
                guestList = constraint(new String[]{commands[1], commands[2]}, guestList);
            }
        }

        printResult(guestList);

    }

    private static void printResult(List<String> guestList) {
        if (guestList.size() != 0) {
            System.out.println(guestList.stream().sorted().map(Object::toString)
                    .collect(Collectors.joining(", ")) + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static List<String> remove(String[] commands, List<String> collection) {
        if (commands[0].equals("StartsWith")) {
            String start = commands[1];
            return collection.stream()
                    .filter(name -> removeStartsWithPredicate.test(name, start))
                    .collect(Collectors.toList());
        } else if (commands[0].equals("EndsWith")) {
            String end = commands[1];
            return collection.stream()
                    .filter(name -> removeEndsWithPredicate.test(name, end))
                    .collect(Collectors.toList());

        } else if (commands[0].equals("Length")) {
            Integer length = Integer.parseInt(commands[1]);
            return collection.stream()
                    .filter(name -> removeLengthPredicate.test(name, length))
                    .collect(Collectors.toList());
        }
        return collection;
    }

    private static List<String> constraint(String[] commands, List<String> guestList) {
        if (commands[0].equals("StartsWith")) {
            String start = commands[1];
            List<String> guestsMatchingCriteria = guestList.stream()
                    .filter(name -> doubleStartsWithPredicate.test(name, start))
                    .collect(Collectors.toList());
            for (int i = 0; i < guestsMatchingCriteria.size(); i++) {
                guestList.add(guestList.indexOf(guestsMatchingCriteria.get(i)), guestsMatchingCriteria.get(i));
            }
        } else if (commands[0].equals("EndsWith")) {
            String end = commands[1];
            List<String> guestsMatchingCriteria = guestList.stream()
                    .filter(name -> doubleEndsWithPredicate.test(name, end))
                    .collect(Collectors.toList());
            for (int i = 0; i < guestsMatchingCriteria.size(); i++) {
                guestList.add(guestList.indexOf(guestsMatchingCriteria.get(i)), guestsMatchingCriteria.get(i));
            }

        } else if (commands[0].equals("Length")) {
            Integer length = Integer.parseInt(commands[1]);
            List<String> guestsMatchingCriteria = guestList.stream()
                    .filter(name -> doubleLengthPredicate.test(name, length))
                    .collect(Collectors.toList());
            for (int i = 0; i < guestsMatchingCriteria.size(); i++) {
                guestList.add(guestList.indexOf(guestsMatchingCriteria.get(i)), guestsMatchingCriteria.get(i));
            }
        }
        return guestList;
    }
}