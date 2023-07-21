package PB03_Shopping_Spree_Exercise;

import javax.sound.sampled.Line;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(";");
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();
        for (String entry : line) {
            String[] personStr = entry.split("=");
            String name = personStr[0];
            double money = Double.parseDouble(personStr[1]);
            Person person = new Person(name, money);
            people.putIfAbsent(name, person);
        }
        line = scanner.nextLine().split(";");
        for (String entry : line) {
            String[] productStr = entry.split("=");
            String name = productStr[0];
            double cost = Double.parseDouble(productStr[1]);
            Product product = new Product(name, cost);
            products.putIfAbsent(name,product);
        }
        String command = "";
        while (!"END".equals(command = scanner.nextLine())) {
            String name = command.split("\\s+")[0];
            String productName = command.split("\\s+")[1];
            Person person = people.get(name);
            Product product= products.get(productName);
            person.buyProduct(product);
        }
        people.forEach((key, value) -> System.out.println(value.toString()));


    }
}
