package PB06_Pokémon_Trainer;

import java.util.List;

public class Trainer {
    private String name;
    private  int numBadges;
    private List<Pokemon> pokemonList;

    public Trainer(String name, List<Pokemon> pokemonList) {
        this.name = name;
        this.numBadges = 0;
        this.pokemonList = pokemonList;
    }

    public String getName() {
        return name;
    }

    public int getNumBadges() {
        return numBadges;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void commandExecuting(String command) {

        if (isExist(command)) {
            numBadges += 1;
        } else {
            for (int i = 0; i < pokemonList.size(); i++) {
                pokemonList.get(i).setHealth(pokemonList.get(i).getHealth() - 10);
                if (pokemonList.get(i).getHealth() <= 0) {
                    pokemonList.remove(i);
                    i--;
                }
            }
        }
    }

    private boolean isExist(String command) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getElement().equals(command)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {

        return String.format("%s %d %d", this.name, this.numBadges, this.pokemonList.size() );
    }
}
