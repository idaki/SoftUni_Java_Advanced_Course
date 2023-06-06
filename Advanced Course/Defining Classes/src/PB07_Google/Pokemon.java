package PB07_Google;

public class Pokemon {
    private String name;
    private String pokemon;
    private String type;

    public Pokemon(String name, String pokemon, String type) {
        this.name = name;
        this.pokemon = pokemon;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.pokemon+" " +this.type;
    }
}



