package football.entities.field;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;
import football.utils.IntegerUtils;
import football.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public abstract class BaseField implements Field {
    private String name;
    private int capacity;//num of players
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    protected BaseField(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (StringUtils.isNullOrEmpty(name)) {
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setCapacity(int capacity) {

        this.capacity = capacity;
    }


    @Override
    public int sumEnergy() {
        return supplements.stream()
                .mapToInt(Supplement::getEnergy)
                .sum();
    }

    @Override
    public void addPlayer(Player player) {
        int currentNumPlayers = players.size();
        if (!IntegerUtils.isCapacityAvailable(currentNumPlayers, this.capacity)) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
        players.add(player);
    }

    //TODO logic check
    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        String patter = "%s (%s):"
                + System.lineSeparator()
                + "Player: %s"
                + System.lineSeparator()
                + "Supplement: %d"
                + System.lineSeparator()
                + "Energy: %d";
//TODO check logic
        return String.format(patter
                , this.name
                , this.getClass().getSimpleName()//  Is this correct?
                , players.isEmpty()? "none" : players.stream()
                        .map(Player::getName)
                        .collect(Collectors.joining(" "))
                ,supplements.size(),
                this. sumEnergy()
                ).trim();

    }

    @Override
    public Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(this.players);
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
