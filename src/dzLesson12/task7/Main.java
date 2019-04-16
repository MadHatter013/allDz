package dzLesson12.task7;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Employee[] employees = { new Employee("Иванов Иван ", 3000), new Employee("Петров Петр ",900),
                new Employee("Николайчук Николай ",32000), new Employee("Смирнов Сергей",4200)};
        Employee employeeDay = new Employee("Petya", 18200, LocalDate.of(2018,8,8));
        Report report = new Report();
        FullReport fullReport = new FullReport();
        fullReport.generateReport(employeeDay);
        for ( Employee e: employees) {
            report.generateReport(e);
        }

    }
}
