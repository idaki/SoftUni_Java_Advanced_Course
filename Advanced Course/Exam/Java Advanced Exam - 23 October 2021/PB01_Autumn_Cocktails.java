import java.util.*;
import java.util.stream.Collectors;

public class PB01_Autumn_Cocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ingredientsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] freshnessArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        TreeMap<String, Integer> cocktailsMap = new TreeMap<>();
        for (int element : ingredientsArr) {
            ingredientsQueue.offer(element);
        }

        for (int element : freshnessArr) {
            freshnessStack.push(element);
        }

        while (ingredientsQueue.size() > 0 && freshnessStack.size() > 0) {
            int currentIngredient = ingredientsQueue.peek();
            int currentFreshness = freshnessStack.peek();
            int currentMultiplication = currentIngredient * currentFreshness;
           if (currentIngredient == 0) {
               ingredientsQueue.poll();
               continue;
           }

            ingredientsQueue.poll();
            freshnessStack.pop();

            if (currentMultiplication == 150) {
                String currentCocktailName = "Pear Sour";
                updateCocktailMap(cocktailsMap, currentCocktailName);

            } else if (currentMultiplication == 250) {
                String currentCocktailName = "The Harvest";
                updateCocktailMap(cocktailsMap, currentCocktailName);
            } else if (currentMultiplication == 300) {
                String currentCocktailName = "Apple Hinny";
                updateCocktailMap(cocktailsMap, currentCocktailName);
            } else if (currentMultiplication == 400) {
                String currentCocktailName = "High Fashion";
                updateCocktailMap(cocktailsMap, currentCocktailName);
            } else {
               ingredientsQueue.offer(currentIngredient+5);
            }
        }
        int sum = 0;
        if (ingredientsQueue.size()>0){
            for (int element: ingredientsQueue) {
                sum+=element;
            }
        }

        if (ingredientsQueue.size()>0){
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
            System.out.println("Ingredients left: "+ sum);
        } else if (cocktailsMap.size()!=4) {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }else{
            System.out.println("It's party time! The cocktails are ready!");
        }

        if (cocktailsMap.size()>0){
            cocktailsMap.forEach((k,v)-> System.out.printf(" # %s --> %d%n",k,v));
        }
    }


    public static TreeMap updateCocktailMap(TreeMap<String, Integer> cocktailsMap, String currentCocktailName) {
        if (!cocktailsMap.containsKey(currentCocktailName)) {
            cocktailsMap.put(currentCocktailName, 1);
        } else {
            int currentAmount = cocktailsMap.get(currentCocktailName);
            cocktailsMap.replace(currentCocktailName, currentAmount + 1);
        }
        return cocktailsMap;
    }
}
