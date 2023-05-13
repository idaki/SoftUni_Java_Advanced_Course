package Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PB04_Basic_Queue_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] command = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] dataSet = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(dataSet).forEach(stack::offer);

        int numElements = command[0];
        int numPoll = command[1];
        int numToValidate = command[2];

        for (int i = 0; i < numPoll ; i++) {
            stack.poll();
        }

        if (stack.contains(numToValidate)){
            System.out.println("true");
        }else if (!stack.isEmpty()) {
            System.out.println(Collections.min(stack));
        }else{
            System.out.println("0");
        }
    }
}
