package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;

public class SpotRepository implements Repository <Spot>{
    private Collection<Spot> spots;

    public SpotRepository() {
        this.spots = new ArrayList<>();
    }

    @Override
    public Collection<Spot> getCollection() {
        return this.spots;
    }

    @Override
    public void add(Spot entity) {
        spots.add(entity);
    }

    @Override
    public boolean remove(Spot entity) {
        return spots.remove(entity);
    }

    @Override
    public Spot byName(String name) {
        return spots.stream()
                .filter(d->d.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
