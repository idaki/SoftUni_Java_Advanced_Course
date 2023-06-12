import java.util.*;

public class PB01_Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] steelInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] carbonInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        Arrays.stream(steelInput).forEach(steelQueue::offer);
        Arrays.stream(carbonInput).forEach(carbonStack::push);


        TreeMap<String, List<Integer>> resultMap = new TreeMap<>();
        int sumSwords=0;
        while (steelQueue.size() > 0 && carbonStack.size() > 0) {
            int currentSteel = steelQueue.poll();
            int currentCarbon = carbonStack.pop();
            int sumElements = currentSteel + currentCarbon;

            if (sumElements == 70) {
                resultMap.putIfAbsent("Gladius", new ArrayList<>());
                resultMap.get("Gladius").add(1);
                sumSwords++;
            } else if (sumElements == 80) {
                resultMap.putIfAbsent("Shamshir", new ArrayList<>());
                resultMap.get("Shamshir").add(1);
                sumSwords++;
            } else if (sumElements == 90) {
                resultMap.putIfAbsent("Katana", new ArrayList<>());
                resultMap.get("Katana").add(1);
                sumSwords++;
            } else if (sumElements == 110) {
                resultMap.putIfAbsent("Sabre", new ArrayList<>());
                resultMap.get("Sabre").add(1);
                sumSwords++;
            } else {
                currentCarbon += 5;
                carbonStack.push(currentCarbon);
            }
        }

        if (sumSwords>0){
            System.out.printf("You have forged %d swords.%n",sumSwords);
        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQueue.size()==0){
            System.out.println("Steel left: none");
        }else{
            System.out.println("Steel left: ");
           while (steelQueue.size()>0){
               System.out.println(steelQueue.poll());
           }
        }

        if (carbonStack.size()==0){
            System.out.println("Carbon left: none");
        }else {
            System.out.print("Carbon left: ");
            String stack= carbonStack.toString().replaceAll("[\\[\\]]","");
            System.out.println(stack);
        }

        resultMap.forEach((key, value) -> System.out.println(key + ": " + value.size()));


    }
}
