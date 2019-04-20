package dzLesson12.task7;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws ParseException {
        NumberFormat nf = NumberFormat.getInstance();
        Employee[] employees = { new Employee("Иванов Иван ", 3000), new Employee("Петров Петр ",900),
                new Employee("Николайчук Николай ",32000), new Employee("Смирнов Сергей",4200)};
        Employee employeeDay = new Employee("Петренко Петр", 18200, LocalDate.of(2018,8,8));
        Report report = new Report();
        FullReport fullReport = new FullReport();
        fullReport.generateReport(employeeDay, Locale.getDefault());
        System.out.println();
//        for ( Employee e: employees) {
//            report.generateReport(e);
//        }
    }
}
