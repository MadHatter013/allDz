package dzLesson16.task9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void deductStudents(Collection<Student> studentCollection) {
        studentCollection.removeIf(s -> s.averageGrade() < 3);
        studentCollection.forEach(s -> s.setCourse(s.getCourse() + 1));
        studentCollection.forEach(s -> System.out.println("Студент " + s.getName() + " перешел на курс: " + s.getCourse()));
    }

    public static void printStudents(List<Student> students, int course) {
        for (int i = 0; i < students.size(); ) {
            Student student = students.remove(0);
            if (student.getCourse() == course) {
                System.out.println(student.getName() + " учиться на курсе: " + course);
            }
        }
    }

    public static void main(String[] args) {
        List<Student> studentCollection = new ArrayList<>();
        studentCollection.add(new Student("Павел", "АП - 64", 4, 4, 5, 3));
        studentCollection.add(new Student("Николай", "АП - 62", 2, 2, 3, 3));
        studentCollection.add(new Student("Виталий", "АП - 31", 1, 4, 2, 2));
        studentCollection.add(new Student("Инна", "АП - 44", 4, 4, 4, 5));
        studentCollection.add(new Student("Василий", "АП - 63", 1, 5, 4, 5));
        studentCollection.add(new Student("Артем", "АП - 44", 2, 4, 4, 3));

//        deductStudents(studentCollection);

        printStudents(studentCollection, 2);

    }


}

