package PB01_Opinion_Poll_E;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            personList.add(new Person(name, age));
        }
        personList.stream().filter(e-> e.getAge()>30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(e-> System.out.println(e.getName()+" - "+e.getAge()));
    }
}
