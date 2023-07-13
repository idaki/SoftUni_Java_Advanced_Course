package PB04_Say_Hello_Extended_Lab.Class;


import PB04_Say_Hello_Extended_Lab.Interface.Person;

public abstract class BasePerson implements Person {
    private String name;

    public  BasePerson(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public abstract String sayHello();


    public void setName(String name) {
        this.name = name;
    }
}
