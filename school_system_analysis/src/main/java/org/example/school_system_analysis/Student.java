package org.example.school_system_analysis;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String StudentId;
    private String Name;
    private int Attendance;
    private int Homework;
    private int Final;
    private int Midterm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAttendance() {
        return Attendance;
    }

    public void setAttendance(int attendance) {
        Attendance = attendance;
    }

    public int getHomeWork() {
        return Homework;
    }

    public void setHomeWork(int homeWork) {
        Homework = homeWork;
    }

    public int getMidterm() {
        return Midterm;
    }

    public void setMidterm(int midterm) {
        Midterm = midterm;
    }

    public int getHomework() {
        return Homework;
    }

    public void setHomework(int homework) {
        Homework = homework;
    }

    public int getFinal() {
        return Final;
    }

    public void setFinal(int aFinal) {
        Final = aFinal;
    }
    public double calculateFinalScore(){
        return 0.3*Attendance + 0.2*Homework + 0.1*Midterm + 0.4*Final;
    }
    public boolean isTopStudent(){
        return calculateFinalScore() >= 85 && Attendance >=90 && Homework >=85 && Final >=90;
    }

}

