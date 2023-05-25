package LAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PB03_Count_Uppercase_Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> text = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Predicate<String> isUpper = word -> Character.isUpperCase(word.charAt(0));
        text = text.stream().filter(isUpper).collect(Collectors.toList());

        System.out.println(text.size());
        text.forEach(System.out::println);


    }
}
