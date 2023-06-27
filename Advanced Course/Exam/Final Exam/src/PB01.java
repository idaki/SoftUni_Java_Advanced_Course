import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PB01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(toolsQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(substancesStack::push);

        List<Integer> templeList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty() && templeList.size() > 0) {
            int tool = toolsQueue.poll();
            int substance = substancesStack.pop();
            int product = tool * substance;

            if (templeList.contains(product)) {
                templeList.remove(Integer.valueOf(product));
            } else {
                tool++;
                toolsQueue.offer(tool);
                substance--;
                if (substance != 0) {
                    substancesStack.push(substance);
                }
            }
        }


if(templeList.size()>0&& (toolsQueue.isEmpty()||substancesStack.isEmpty())){
    System.out.println("Harry is lost in the temple. Oblivion awaits him.");
} else {
    System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
}



        if (!toolsQueue.isEmpty()){
            String toolsPrint = toolsQueue.toString().replaceAll("[\\[\\]]","");
            System.out.println("Tools: "+ toolsPrint);
        }
        if (!substancesStack.isEmpty()){
            String substancesPrint = substancesStack.toString().replaceAll("[\\[\\]]","");
            System.out.println("Substances: "+ substancesPrint);
        }
        if (templeList.size()>0){
            String templePrint = templeList.toString().replaceAll("[\\[\\]]","");
            System.out.println("Challenges: "+ templePrint);
        }



    }
}
