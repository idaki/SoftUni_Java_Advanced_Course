package PB02_Salary_Increase;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {

        if (this.age < 30) {
            this.salary *= (1 + (bonus / 2) / 100);
        } else {
            this.salary *= (1 + bonus / 100);
        }

    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.1f leva", this.firstName, this.lastName, this.salary);
    }
}
