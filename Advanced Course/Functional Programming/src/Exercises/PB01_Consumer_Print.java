package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class PB01_Consumer_Print {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Consumer<String> print = System.out::println;

        Arrays.stream(input).forEach(print);
    }
}
