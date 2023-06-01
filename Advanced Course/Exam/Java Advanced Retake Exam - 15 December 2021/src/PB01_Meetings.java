import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PB01_Meetings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] maleArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] femaleArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> maleStack =new ArrayDeque<>();
        ArrayDeque<Integer> femaleQueue =new ArrayDeque<>();

        for (int element: maleArr) {
            maleStack.push(element);
        }
        for (int element: femaleArr) {
            femaleQueue.offer(element);
        }


        int countMatches = 0;

        while(maleStack.size()>0 && femaleQueue.size()>0){
            int currentMale = maleStack.peek();
            int currentFemale= femaleQueue.peek();

            if (negativeOrZeroCaseOperation(maleStack, femaleQueue, currentMale, currentFemale)) continue;

            if (specialAgeOperation(maleStack, femaleQueue, currentMale, currentFemale)) continue;

            countMatches = getCountMatches(maleStack, femaleQueue, countMatches, currentMale, currentFemale);
        }
        System.out.println("Matches: " + countMatches);
        if (maleStack.size()==0){
            System.out.println("Males left: none");
        } else {
            String print= Arrays.toString(maleStack.toArray()).replaceAll("[\\[\\]]","");
            System.out.println("Males left: "+print);
        }
        if (femaleQueue.size()==0){
            System.out.println("Females left: none");
        } else {
            String print= Arrays.toString(femaleQueue.toArray()).replaceAll("[\\[\\]]","");
            System.out.println("Females left: "+print);
        }
    }

    private static int getCountMatches(ArrayDeque<Integer> maleStack, ArrayDeque<Integer> femaleQueue, int countMatches, int currentMale, int currentFemale) {
        if ( currentMale == currentFemale){
            countMatches++;
            maleStack.pop();
            femaleQueue.poll();
        }else{
            maleStack.pop();
            femaleQueue.poll();
            maleStack.push(currentMale -2);
        }
        return countMatches;
    }

    private static boolean specialAgeOperation(ArrayDeque<Integer> maleStack, ArrayDeque<Integer> femaleQueue, int currentMale, int currentFemale) {
        if (currentMale %25==0){
            maleStack.pop();
            maleStack.pop();
            return true;
        }
        if (currentFemale %25==0){
            femaleQueue.poll();
            femaleQueue.poll();
            return true;
        }
        return false;
    }

    private static boolean negativeOrZeroCaseOperation(ArrayDeque<Integer> maleStack, ArrayDeque<Integer> femaleQueue, int currentMale, int currentFemale) {
        if (currentMale <=0){
            maleStack.pop();
            return true;
        }
        if (currentFemale <=0){
            femaleQueue.poll();
            return true;
        }
        return false;
    }
}
