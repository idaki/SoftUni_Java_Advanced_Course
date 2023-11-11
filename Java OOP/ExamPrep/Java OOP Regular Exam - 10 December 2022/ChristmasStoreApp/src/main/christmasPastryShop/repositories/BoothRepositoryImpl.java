package christmasPastryShop.repositories;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;

import java.util.ArrayList;
import java.util.Collection;

public class BoothRepositoryImpl implements BoothRepository<Booth> {
    private Collection<Booth> booths;




    public BoothRepositoryImpl() {
        this.booths = new ArrayList<>();

    }

    @Override
    public Booth getByNumber(int number) {
        return this.booths.stream()
                .filter(b -> b.getBoothNumber() == number)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Booth> getAll() {
        return booths;
    }

    @Override
    public void add(Booth booth) {
        booths.add(booth);
    }
}
