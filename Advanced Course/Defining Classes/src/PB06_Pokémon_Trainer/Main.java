package PB06_Pokémon_Trainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "";

        Map<String, List<Pokemon>> pokemonByTrainers = new LinkedHashMap<>();

        while (!"Tournament".equals(line = scanner.nextLine())) {

            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon currentPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            pokemonByTrainers.putIfAbsent(trainerName, new ArrayList<>());
            pokemonByTrainers.get(trainerName).add(currentPokemon);
        }

        List<Trainer> trainerList = pokemonByTrainers.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(), t.getValue()))
                .collect(Collectors.toList());

        while (!"End".equals(line = scanner.nextLine())) {
            for (Trainer trainer : trainerList) {
                trainer.commandExecuting(line);
            }
        }
        trainerList.stream()
                .sorted(Comparator.comparingInt(Trainer::getNumBadges).reversed())
                .forEach(System.out::println);
    }
}
