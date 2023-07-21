package PB06_Animals.Animal;

import PB06_Animals.Animal.Animal;

public class Dog extends Animal {

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public String produceSound() {
        return "Woof!";
    }
}
