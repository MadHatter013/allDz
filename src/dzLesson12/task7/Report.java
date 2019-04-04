package dzLesson12.task7;

import java.util.Formatter;

public class Report {
    static void generateReport(Employee employee){
        Formatter f = new Formatter();
        int i = 50 - employee.getFullName().length();
        f.format("%10s получает зарплату: %"+i+".2f",employee.getFullName(),employee.getSalary());
        System.out.println(f);
    }

}
