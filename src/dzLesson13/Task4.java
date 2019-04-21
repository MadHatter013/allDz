package dzLesson13;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task4 {
    public static void main(String[] args){
        LocalDate easter = LocalDate.of(2019,4,28);
        LocalDate laborDay = LocalDate.of(2019,5,1);
        LocalDate victoryDay = LocalDate.of(2019,5,9);
        LocalDate trinity = LocalDate.of(2019,6,16);
        LocalDate constitutionDayOfUkraine = LocalDate.of(2019,6,28);

        DateTimeFormatter dt1 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        DateTimeFormatter dt2 = DateTimeFormatter.ofPattern("d MMMM, yyyy");
        DateTimeFormatter dt3 = DateTimeFormatter.ofPattern("yyyy MMMM, d");
        System.out.println(easter.format(dt1));
        System.out.println(laborDay.format(dt2));
        System.out.println(victoryDay.format(dt3));
        System.out.println(trinity.format(dt1));
        System.out.println(constitutionDayOfUkraine.format(dt3));
    }
}
