package dzLesson16.task9;

import java.util.Objects;

public class Student {
    private String name;
    private String group;
    private int course;
    private double gradeInBiology;
    private double gradeInHistory;
    private double gradeInMath;

    public Student() {
    }

    public Student(String name, String group, int course, double gradeInBiology, double gradeInHistory, double gradeInMath) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.gradeInBiology = gradeInBiology;
        this.gradeInHistory = gradeInHistory;
        this.gradeInMath = gradeInMath;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public double getGradeInBiology() {
        return gradeInBiology;
    }

    public double getGradeInHistory() {
        return gradeInHistory;
    }

    public double getGradeInMath() {
        return gradeInMath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setGradeInBiology(double gradeInBiology) {
        this.gradeInBiology = gradeInBiology;
    }

    public void setGradeInHistory(double gradeInHistory) {
        this.gradeInHistory = gradeInHistory;
    }

    public void setGradeInMath(double gradeInMath) {
        this.gradeInMath = gradeInMath;
    }

    public double averageGrade() {
        return (gradeInBiology + gradeInHistory + gradeInMath) / 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                Double.compare(student.gradeInBiology, gradeInBiology) == 0 &&
                Double.compare(student.gradeInHistory, gradeInHistory) == 0 &&
                Double.compare(student.gradeInMath, gradeInMath) == 0 &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course, gradeInBiology, gradeInHistory, gradeInMath);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", gradeInBiology=" + gradeInBiology +
                ", gradeInHistory=" + gradeInHistory +
                ", gradeInMath=" + gradeInMath +
                '}';
    }
}
