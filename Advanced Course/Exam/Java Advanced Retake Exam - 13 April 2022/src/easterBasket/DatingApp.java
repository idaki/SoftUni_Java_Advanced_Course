package easterBasket;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;



public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> maleS = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(maleS::push);
        ArrayDeque<Integer> femaleQ = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(femaleQ::offer);
        int matchesCount = 0;
        while (!maleS.isEmpty() && !femaleQ.isEmpty()) {
            int valueM = maleS.peek();
            int valueF = femaleQ.peek();
            if (valueM <= 0) {
                maleS.pop();
                continue;
            }
            if (valueF <= 0) {
                femaleQ.poll();
                continue;
            }
            if (valueM % 25 == 0) {
                maleS.pop();

                if (maleS.isEmpty()) {
                    break;
                } else {
                    maleS.pop();
                }
                continue; // Skip matching for this iteration
            } else if (valueF % 25 == 0) {
                femaleQ.poll();

                if (femaleQ.isEmpty()) {
                    break;
                } else {
                    femaleQ.poll();
                }
                continue; // Skip matching for this iteration
            }

            // Remaining matching logic
            if (valueM == valueF) {
                maleS.pop();
                femaleQ.poll();
                matchesCount++;
            } else {
                femaleQ.poll();
                maleS.push(maleS.pop() - 2);
            }
        }
        System.out.printf("Matches: %d%n", matchesCount);
        if (maleS.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            String result = maleS.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(result);
        }
        if (femaleQ.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            String result = femaleQ.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(result);
        }
    }
}
