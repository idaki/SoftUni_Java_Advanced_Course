package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class MagicRepositoryImpl implements MagicRepository<Magic> {
    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new LinkedList<>();
    }

    @Override
    public Collection getData() {
        return this.data;
    }

    @Override
    public void addMagic(Magic model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY);
        }
        data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
        return data.remove(model);
    }

    @Override
    public Magic findByName(String name) {
        return data.stream()
                .filter(m->m.getName()
                        .equals(name))
                .findFirst().orElse(null);
    }
}
