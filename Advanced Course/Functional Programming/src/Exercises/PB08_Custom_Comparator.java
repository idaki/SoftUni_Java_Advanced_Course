package Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PB08_Custom_Comparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.stream(numbers).sorted().filter(num->num %2==0).forEach(num-> System.out.print(num+" "));
        Arrays.stream(numbers).sorted().filter(num->num %2!=0).forEach(num-> System.out.print(num+" "));

    }
}
