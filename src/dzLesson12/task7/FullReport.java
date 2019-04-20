package dzLesson12.task7;

import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class FullReport {
    static void generateReport(Employee employee, Locale locale){
        ResourceBundle rb = ResourceBundle.getBundle("topic", locale);
        String key = rb.getString("topic2");
        System.out.println(key);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        Formatter f = new Formatter();
        int i = 50 - employee.getFullName().length();
        System.out.println(employee.getFullName() + " получает зарплату: " + nf.format(employee.getSalary()));
//        f.format("%10s получает зарплату: %"+i+".2f",employee.getFullName(),employee.getSalary());
        System.out.println(f);
        System.out.println("Дата выдачи зарплаты: " + employee.getSalaryDay());

    }
}
