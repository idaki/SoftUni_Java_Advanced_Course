package PB06_Animals.Animal.Cat.Tomcat;

import PB06_Animals.Animal.Cat.Cat;

public class Tomcat extends Cat {

    private static String gender = "Male";

    public Tomcat(String name, int age) {
        super(name, age, gender);
    }
    public String produceSound() {
        return "MEOW";
    }
}
