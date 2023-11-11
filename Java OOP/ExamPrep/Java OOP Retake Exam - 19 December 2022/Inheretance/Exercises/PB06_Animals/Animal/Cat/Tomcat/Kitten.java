package PB06_Animals.Animal.Cat.Tomcat;

import PB06_Animals.Animal.Cat.Cat;

public class Kitten extends Cat {

    private static String gender = "Female";

    public Kitten(String name, int age) {
        super(name, age, gender);
    }

    public String produceSound() {
        return "Meow";
    }
}
