import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PB01_Energy_Drinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] caffeineInput = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] energyDrinksInput = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int caffeineMax = 0;

        ArrayDeque<Integer> energyDrinksQueue = new ArrayDeque<>();
        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();
        Arrays.stream(energyDrinksInput).forEach(energyDrinksQueue::offer);
        Arrays.stream(caffeineInput).forEach(caffeineStack::push);

        while (!caffeineStack.isEmpty() && !energyDrinksQueue.isEmpty() && caffeineMax<=300) {
            int caffeine = caffeineStack.pop();
            int energyDrink = energyDrinksQueue.poll();

            if (caffeine * energyDrink + caffeineMax<= 300) {
                caffeineMax += caffeine*energyDrink;
            } else{
                energyDrinksQueue.offer(energyDrink);
                caffeineMax-=30;
                if (caffeineMax <0){
                    caffeineMax = 0;
                }
            }
        }
        if(!energyDrinksQueue.isEmpty()){
        String drinksPrint =  energyDrinksQueue.toString().replaceAll("[\\[\\]]","");
            System.out.println("Drinks left: "+drinksPrint);
        } else  {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n",caffeineMax);
//•	On the first line:
//o	If Stamat hasn't drunk all the energy drinks, print the remaining ones separated by a comma and a space ", ":
//	"Drinks left: { remaining drinks separated by ", " }"
//o	If Stamat has drunk all the energy drinks, print:
//	"At least Stamat wasn't exceeding the maximum caffeine."
//•	On the next line, print:
//o	"Stamat is going to sleep with { current caffeine } mg caffeine."
    }
}
