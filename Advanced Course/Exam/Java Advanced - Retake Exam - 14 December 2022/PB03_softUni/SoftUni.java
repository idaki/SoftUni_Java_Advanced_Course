package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public String insert(Student student) {
        StringBuilder sb = new StringBuilder();
        if (this.data.size() >= capacity) {
            sb.append("The hall is full.");
        } else if (this.data.contains(student)) {
            sb.append("Student is already in the hall.");
        } else {
            sb.append("Added student ")
                    .append(student.getFirstName())
                    .append(" ")
                    .append(student.getLastName())
                    .append(".");
            this.data.add(student);
        }
        return sb.toString();
    }

    public String remove(Student student) {
        boolean removed = this.data.remove(student);
        if (removed) {
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found.";
        }
    }

    public String getStudent(String firstName, String lastName) {
        return this.data.stream()
                .filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
                .findFirst()
                .map(s -> String.format("Student: %s %s, Best Course = %s",
                        s.getFirstName(), s.getLastName(), s.getBestCourse()))
                .orElse("Student not found.");
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hall size: ").append(this.data.size()).append("\n");
        this.data.forEach(s -> sb.append("Student: ")
                .append(s.getFirstName())
                .append(" ")
                .append(s.getLastName())
                .append(", Best Course = ")
                .append(s.getBestCourse()).append("\n"));
        return sb.toString().trim();
    }
}
