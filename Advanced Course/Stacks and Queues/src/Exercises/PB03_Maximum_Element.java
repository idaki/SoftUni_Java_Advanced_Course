package Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PB03_Maximum_Element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numCommands; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int command = input[0];
            if (command == 1) {
                int element = input[1];
                stack.push(element);
            } else if (command == 2) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                if (!stack.isEmpty()) {
                    int print = Collections.max(stack);
                    System.out.println(print);
                }
            }

        }
    }
}

