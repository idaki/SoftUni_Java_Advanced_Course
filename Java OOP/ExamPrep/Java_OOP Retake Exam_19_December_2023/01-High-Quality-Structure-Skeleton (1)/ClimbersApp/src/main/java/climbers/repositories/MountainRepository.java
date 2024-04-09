package climbers.repositories;

import climbers.models.climber.Climber;
import climbers.models.mountain.Mountain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class MountainRepository implements Repository<Mountain>{

   private HashMap<String,Mountain> mountains;


    public MountainRepository() {
        this.mountains = new HashMap<>();
    }

    @Override
    public Collection<Mountain> getCollection() {
        return Collections.unmodifiableCollection(mountains.values());
    }

    @Override
    public void add(Mountain entity) {
    mountains.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Mountain entity) {
        return mountains.remove(entity.getName(),entity);
    }

    @Override
    public Mountain byName(String name) {
        return mountains.get(name);
    }
}
