package Exercises;

import java.util.*;

public class PB02_Basic_Stack_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] command = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] dataSet = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(dataSet).forEach(stack::push);

        int numElements = command[0];
        int numPop = command[1];
        int numToValidate = command[2];

        for (int i = 0; i < numPop ; i++) {
            stack.pop();
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
