package PB07_Custom_List;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();
        String input = "";

        while (!"END".equals(input = scanner.nextLine())) {
            String[] commandParts = input.split(" ");
            String commandName = commandParts[0];

            if ("Add".contains(commandName)) {
                String elementToAdd = commandParts[1];
                customList.add(elementToAdd);
            } else if ("Remove".contains(commandName)) {
                int index = Integer.parseInt(commandParts[1]);
                customList.remove(index);

            } else if ("Contains".contains(commandName)) {
                String elementToSearch = commandParts[1];
                System.out.println(customList.contains(elementToSearch));

            } else if ("Swap".contains(commandName)) {
                int firstIndex = Integer.parseInt(commandParts[1]);
                int secondIndex = Integer.parseInt(commandParts[2]);
                customList.swap(firstIndex, secondIndex);

            } else if ("Greater".contains(commandName)) {
                String element = commandParts[1];
                System.out.println(customList.countGreaterThan(element));

            } else if ("Min".contains(commandName)) {
                System.out.println(customList.min());

            } else if ("Max".contains(commandName)) {
                System.out.println(customList.max());

            } else if ("Print".contains(commandName)) {
                System.out.println(customList);
            } else {
                System.out.println("Invalid command");
            }
        }
        System.out.println();
    }
}
