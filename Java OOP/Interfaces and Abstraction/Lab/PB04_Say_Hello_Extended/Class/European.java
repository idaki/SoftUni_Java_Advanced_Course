package PB04_Say_Hello_Extended_Lab.Class;

import PB04_Say_Hello_Extended_Lab.Interface.Person;

public class European extends BasePerson {


    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
