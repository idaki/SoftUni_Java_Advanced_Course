package LAB;

import java.util.*;
import java.util.stream.Collectors;

public class PB08_Academy_Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            List<Double> gradesInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());

            if(!students.containsKey(name)){
                students.put(name, gradesInput);
            }
            else{
                students.get(name).addAll(gradesInput);
            }
        }

        for (String student: students.keySet()){
            System.out.println(String.format("%s is graduated with %s", student, getAverage(students.get(student))));
        }
    }

    private static Double getAverage(List<Double> grades){
        double total = 0d;
        for (int i = 0; i < grades.size(); i++) {
            total += grades.get(i);
        }
        return total / grades.size();
    }
}