package PB07_Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        HashMap<String, Person> persons = new HashMap<>();


        while (!"End".equals(command = scanner.nextLine())) {
            String[] tokens = command.split("\\s+");
            String name = tokens[0];

            persons.putIfAbsent(name,new Person());

            if (tokens[1].equals("company")) {
                Company company = new Company(tokens[0], tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                persons.get(name).setCompany(company);
            } else if (tokens[1].equals("pokemon")) {
                Pokemon pokemon = new Pokemon(tokens[0], tokens[2], tokens[3]);
                persons.get(name).getPokemons().add(pokemon);
            } else if (tokens[1].equals("parents")) {
                Parent parent = new Parent(tokens[0], tokens[2], tokens[3]);
                persons.get(name).getParents().add(parent);
            } else if (tokens[1].equals("children")) {
                Child child = new Child(tokens[0], tokens[2], tokens[3]);
                persons.get(name).getChildren().add(child);
            } else if (tokens[1].equals("car")) {
                int speed = Integer.parseInt(tokens[3]);
                Car car = new Car(name, tokens[2], speed);
                persons.get(name).setCar(car);

            }
        }
        command = scanner.nextLine();
        System.out.println(command);
        System.out.println(persons.get(command));
    }
}
