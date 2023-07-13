package PB04_Say_Hello_Extended_Lab.Class;

import PB04_Say_Hello_Extended_Lab.Interface.Person;

public class Chinese extends BasePerson{

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }

}
