package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }


    public void add(Person person) {
        if (capacity > roster.size()) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : this.roster) {
            if (person.getName().equals(name)) {
                this.roster.remove(person);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown){
        for (Person person : this.roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                return person;
            }
        }
        return null;
    }

    public int getCount(){
        int count = this.roster.size();
        return count;
    }



    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The people in the hotel ").append(name).append(" are:\n");
        for (Person person : roster) {
            sb.append(person).append("\n");
        }
        return sb.toString();
    }

}
