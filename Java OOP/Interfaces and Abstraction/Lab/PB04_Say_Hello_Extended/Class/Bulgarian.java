package PB04_Say_Hello_Extended_Lab.Class;


public class Bulgarian extends BasePerson
{

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
