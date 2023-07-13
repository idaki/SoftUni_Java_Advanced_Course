package PB03_Say_Hello_Lab.Class;

import PB03_Say_Hello_Lab.Interface.Person;

public class Bulgarian implements Person {
    private String name;

    public Bulgarian(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
