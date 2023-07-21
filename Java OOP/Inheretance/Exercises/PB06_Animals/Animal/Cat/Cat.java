package PB06_Animals.Animal.Cat;

import PB06_Animals.Animal.Animal;

public class Cat extends Animal {

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }
    public String produceSound() {
        return "Meow meow";
    }
}
