package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : this.data) {
            String currentName = parrot.getName();
            if (currentName.equals(name)) {
                this.data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        Parrot returnValue = null;
        for (Parrot parrot : this.data) {
            String currentName = parrot.getName();
            if (currentName.equals(name)) {
                parrot.setAvailable(false);
                returnValue = parrot;
            }
        }
        return returnValue;
    }

    public List<Parrot>	sellParrotBySpecies(String species){

        return this.data.stream().filter(e->e.getSpecies().equals(species))
                .peek(e -> e.setAvailable(false))
                .collect(Collectors.toList());
    }

    public int count(){
        return this.data.size();
    }

    public String report () {

        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(this.name).append(":\n");
        this.data.stream().filter(Parrot::isAvailable).forEach(e->sb.append(e).append("\n"));

        return sb.toString().trim();
    }
}