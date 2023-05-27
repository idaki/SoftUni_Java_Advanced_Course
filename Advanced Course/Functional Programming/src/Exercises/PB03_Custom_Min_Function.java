package Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class PB03_Custom_Min_Function {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[],Integer> getMinNumber = array-> IntStream.of(array)
                .min().orElse(0);
        System.out.println(getMinNumber.apply(arrayInput));
    }

}
