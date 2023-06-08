import java.util.*;

public class Main {
    public static void main(String[] args) {

Integer[] arr ={1,2,3,4,5,6,9,8,7};
int[] indices  = {0,1,2,3,4,5,6,7,8,9};
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>() {{
            put(0, new ArrayList<>(List.of(1)));
            put(1, new ArrayList<>(List.of(2)));
            put(2, new ArrayList<>(List.of(3)));
            put(3, new ArrayList<>(List.of(4)));
            put(4, new ArrayList<>(List.of(5)));
            put(5, new ArrayList<>(List.of(6)));
            put(6, new ArrayList<>(List.of(9)));
            put(7, new ArrayList<>(List.of(8)));
            put(8, new ArrayList<>(List.of(7)));
        };




        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));

    }
}
    }
}