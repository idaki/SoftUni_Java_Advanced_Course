package LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PB04_Add_VAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> prices = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        prices.forEach(e-> System.out.printf("%.2f%n", e*1.2));
    }
}
