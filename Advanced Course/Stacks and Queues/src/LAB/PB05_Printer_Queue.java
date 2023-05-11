package LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PB05_Printer_Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while (!"print".equals(input = scanner.nextLine())) {

            if (!"cancel".equals(input)) {
                printerQueue.offer(input);
            } else if (printerQueue.isEmpty()) {
                System.out.println("Printer is on standby");
            } else {
                String firstJob = printerQueue.poll();
                System.out.println("Canceled " + firstJob);
            }
        }
        while (!printerQueue.isEmpty()){
            System.out.println(printerQueue.poll());
        }
    }
}
