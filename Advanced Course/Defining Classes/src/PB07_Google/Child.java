package PB07_Google;

public class Child {
    private String name;
    private String child;
    private String birthday;

    public Child(String name, String child, String birthday) {
        this.name = name;
        this.child = child;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return child + " " + birthday;
    }
}
