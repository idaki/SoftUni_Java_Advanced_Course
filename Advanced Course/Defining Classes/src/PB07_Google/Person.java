package PB07_Google;



import java.util.ArrayList;
import java.util.List;

public class Person {


    private String name;
    private Company company;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;
    private  Car car;

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company:").append(System.lineSeparator());
        if (company != null) {
            sb.append(company).append(System.lineSeparator());
        }
        sb.append("Car:").append(System.lineSeparator());
        if (car != null) {
            sb.append(car).append(System.lineSeparator());
        }
        sb.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : pokemons) {
            sb.append(pokemon).append(System.lineSeparator());
        }

        sb.append("Parents:").append(System.lineSeparator());
        for (Parent parent : parents) {
            sb.append(parent).append(System.lineSeparator());
        }

        sb.append("Children:").append(System.lineSeparator());


        for (Child child : children) {
            sb.append(child).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
