package PB07_Google;

public class Parent {

    private String name;
    private String parent;
    private String birthday;

    public Parent(String name, String parent, String birthday) {
        this.name = name;
        this.parent = parent;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return this.parent+" "+this.birthday;
    }
}

