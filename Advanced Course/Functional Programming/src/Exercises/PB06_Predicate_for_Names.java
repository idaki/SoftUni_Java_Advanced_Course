package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PB06_Predicate_for_Names {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        BiPredicate<Integer, String> isLengthOfNameLessOrEqualToN = (num, name)-> name.length()<=num;

        Arrays.stream(names).filter(name-> isLengthOfNameLessOrEqualToN.test(n,name)).forEach(System.out::println);
    }
}
