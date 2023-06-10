package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {

        return this.data.stream().filter(e -> e.getName().equals(name))
                .findFirst()
                .map(animal -> {
                    this.data.remove(animal);
                    return true;
                })
                .orElse(false);
    }

    public Animal getAnimal(String name, String caretaker) {

        return this.data.stream()
                .filter(animal -> animal.getName().equals(name) && animal.getCaretaker().equals(caretaker))
                .findFirst().orElse(null);
    }

    public Animal getOldestAnimal() {

        return this.data.stream().max(Comparator.comparing(Animal::getAge)).orElse(null);
    }

    public int getCount(){

        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:\n");
        this.data.forEach(e-> sb.append(e.getName()).append(" ").append(e.getCaretaker()).append("\n"));
        return sb.toString().trim();
    }




}
