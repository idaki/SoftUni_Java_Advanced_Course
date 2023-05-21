package LAB;

import java.util.*;

public class PB05_Average_Students_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, ArrayList<Double>> studentsMap = getStudentsInfo(scanner, n);
        for (Map.Entry<String, ArrayList<Double>> entry : studentsMap.entrySet()) {
            String name = entry.getKey();

            double sum=0;
            StringBuilder printGrades = new StringBuilder();
            for (double grade: entry.getValue()) {
                printGrades.append(String.format("%.2f ", grade));
                sum+=grade;
            }
           double averageGrade = sum/entry.getValue().size();
            System.out.printf("%s -> %s(avg: %.2f)%n", name, printGrades, averageGrade);

        }


    }

    private static TreeMap<String, ArrayList<Double>> getStudentsInfo(Scanner scanner, int n) {
        TreeMap<String, ArrayList<Double>> studentsMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] lineInput = scanner.nextLine().split("\\s+");
            String name = lineInput[0];
            Double grade = Double.parseDouble(lineInput[1]);

            if (!studentsMap.containsKey(name)) {
                studentsMap.put(name, new ArrayList<>());
            }
            studentsMap.get(name).add(grade);
        }
        return studentsMap;
    }
}
