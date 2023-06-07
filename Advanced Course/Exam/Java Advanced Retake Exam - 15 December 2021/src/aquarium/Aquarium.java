package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size; //the volume of the pool


    public Aquarium(String name, int capacity, int size) {
        this.fishInPool = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
        this.size = size;
    }

    public List<Fish> getAquarium() {
        return fishInPool;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        int fishNumber = this.fishInPool.size();
        return fishNumber;
    }

    public void add(Fish fish) {
        if (isValid(fish)) {
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        for (Fish entry : this.fishInPool) {
            String currentName = entry.getName();
            if (currentName.equals(name)) {
                this.fishInPool.remove(entry);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name) {
        for (Fish entry : this.fishInPool) {
            String currentName = entry.getName();
            if (currentName.equals(name)) {
                return entry;
            }
        }
        return null;
    }

    public boolean isValid(Fish fish) {
        if (this.fishInPool.size() >= this.capacity) {
            return false;
        }

        for (Fish entry : this.fishInPool) {
            String name = entry.getName();
            if (fish.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public String report(){
      StringBuilder sb = new StringBuilder();
      sb.append("Aquarium Info:\n");
      sb.append("Aquarium: ").append(this.name).append(" ^ ").append(this.getSize()).append("\n");
      this.fishInPool.forEach(e->sb.append(e).append("\n"));
return sb.toString();
    }
}
