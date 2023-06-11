import java.util.*;

public class PB01_Its_Chocolate_Time {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] milkQtyInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double[] cacaoQtyInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();


        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        Arrays.stream(milkQtyInput).forEach(milkQueue::offer);
        Arrays.stream(cacaoQtyInput).forEach(cacaoStack::push);
        TreeMap<String, List<Integer>> printMap = new TreeMap<>();

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double milk = milkQueue.peek();
            double cacao = cacaoStack.peek();
            double formula = cacao/(milk+cacao)*100;
            
            if (formula==30){
                String token = "Milk Chocolate";
                printMap.putIfAbsent(token, new ArrayList<>() );
                printMap.get(token).add(1);
                milkQueue.poll();
                cacaoStack.pop();
            } else if (formula == 50 ) {
                String token = "Dark Chocolate";
                printMap.putIfAbsent(token, new ArrayList<>() );
                printMap.get(token).add(1);
                milkQueue.poll();
                cacaoStack.pop();
            } else if (formula==100) {
                String token = "Baking Chocolate";
                printMap.putIfAbsent(token, new ArrayList<>() );
                printMap.get(token).add(1);
                milkQueue.poll();
                cacaoStack.pop();
            }else{
               cacaoStack.pop();
               double currentMilk= milkQueue.poll();
               currentMilk+=10;
               milkQueue.offer(currentMilk);

            }

        }

        if (printMap.size()==3){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        printMap.forEach((key, value) -> System.out.println("# " + key + " --> " + value.size()));


    }
}
