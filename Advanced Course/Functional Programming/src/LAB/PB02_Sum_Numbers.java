package LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PB02_Sum_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Function<List<Integer>, Integer> sumElementsInList = list -> {
            int sum = 0;
            for (int number : list) {
                sum += number;
            }

            return sum;
        };

        System.out.println("Count = "+input.size());
        System.out.println("Sum = " + sumElementsInList.apply(input) );

    }
}
