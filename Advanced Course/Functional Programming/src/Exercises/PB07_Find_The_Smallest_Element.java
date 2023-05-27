package Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PB07_Find_The_Smallest_Element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
          List<Integer> numbers = Arrays.stream(scanner.nextLine()
                         .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

           int min= Collections.min(numbers);
        System.out.println(numbers.lastIndexOf(min));

        
    }
}
