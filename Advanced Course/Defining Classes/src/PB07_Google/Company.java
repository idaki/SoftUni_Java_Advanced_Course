package PB07_Google;

public class Company {

    private String name;
    private String company;
    private String department;
    private Double salary;

    public Company(String name, String company, String department, Double salary) {
        this.name = name;
        this.company = company;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getDepartment() {
        return department;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.company, this.department, this.salary);
    }
}
