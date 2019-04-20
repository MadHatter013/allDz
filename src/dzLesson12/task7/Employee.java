package dzLesson12.task7;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String fullName;
    private double salary;
    private LocalDate salaryDay;

    public Employee() {
    }

    public Employee(String fullName, double salary) {
        this.fullName = fullName;
        this.salary = salary;
    }

    public Employee(String fullName, double salary, LocalDate salaryDay) {
        this.fullName = fullName;
        this.salary = salary;
        this.salaryDay = salaryDay;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getSalaryDay() {
        return salaryDay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalaryDay(LocalDate salaryDay) {
        this.salaryDay = salaryDay;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", salary=" + salary +
                ", salaryDay=" + salaryDay +
                '}';
    }
}
