package PB03_Say_Hello_Lab.Class;

import PB03_Say_Hello_Lab.Interface.Person;

public class European implements Person {
    private String name;

    public European(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
