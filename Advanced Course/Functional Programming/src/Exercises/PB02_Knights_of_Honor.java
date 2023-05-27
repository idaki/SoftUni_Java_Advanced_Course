package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class PB02_Knights_of_Honor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Consumer<String> print = name-> System.out.println("Sir "+ name);

        Arrays.stream(input).forEach(print);
    }
}
