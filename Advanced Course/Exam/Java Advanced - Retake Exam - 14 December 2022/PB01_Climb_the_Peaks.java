import java.util.*;

public class PB01_Climb_the_Peaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> foodStack = new ArrayDeque<>();
        ArrayDeque<Integer> staminaQueue = new ArrayDeque<>();

        List<String> peakList = new ArrayList<>
                (Arrays.asList("Vihren", "Kutelo", "Banski Suhodol","Polezhan", "Kamenitza"));
        List<String> peakConquered = new ArrayList<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).forEach(foodStack::push);

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).forEach(staminaQueue::offer);

        boolean isSuccessful = false;

        int countDays = 0;

        while (!foodStack.isEmpty() && !staminaQueue.isEmpty() && countDays < 7) {
            countDays++;
            int portion = foodStack.pop();
            int stamina = staminaQueue.poll();
            String peak = peakList.get(0);
            if (peak.equals("Vihren") && portion + stamina >= 80) {
                peakConquered.add(peak);
                peakList.remove(0);
            } else if (peak.equals("Kutelo") && portion + stamina >= 90) {
                peakConquered.add(peak);
                peakList.remove(0);
            } else if (peak.equals("Banski Suhodol") && portion + stamina >= 100) {
                peakConquered.add(peak);
                peakList.remove(0);
            } else if (peak.equals("Polezhan") && portion + stamina >= 60) {
                peakConquered.add(peak);
                peakList.remove(0);
            } else if (peak.equals("Kamenitza") && portion + stamina >= 70) {
                peakConquered.add(peak);
                peakList.remove(0);
            }

            if (peakList.isEmpty()){
                isSuccessful= true;
                break;
            }
        }

        if (isSuccessful){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");

        }else{
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if(!peakConquered.isEmpty()){
            System.out.println("Conquered peaks:");
            peakConquered.forEach(System.out::println);
        }

    }
}
