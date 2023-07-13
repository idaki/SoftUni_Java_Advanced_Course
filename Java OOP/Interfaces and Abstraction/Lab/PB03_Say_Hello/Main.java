package PB03_Say_Hello_Lab;

import PB03_Say_Hello_Lab.Class.Bulgarian;
import PB03_Say_Hello_Lab.Class.Chinese;
import PB03_Say_Hello_Lab.Class.European;
import PB03_Say_Hello_Lab.Interface.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Bulgarian("Peter"));
        persons.add(new European("Peter"));
        persons.add(new Chinese("Peter"));
        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }
}
