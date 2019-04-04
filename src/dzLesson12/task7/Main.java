package dzLesson12.task7;

public class Main {
    public static void main(String[] args){
        Employee[] employees = { new Employee("Иванов Иван ", 3000), new Employee("Петров Петр ",900),
                new Employee("Николайчук Николай ",32000), new Employee("Смирнов Сергей",4200)};
        Report report = new Report();

        for ( Employee e: employees) {
            report.generateReport(e);
        }

    }
}
