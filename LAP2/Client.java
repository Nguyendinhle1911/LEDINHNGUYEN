package LAP2;
import LAP2.Student;

public class Client {
    public static void main(String[] args) {
        Student studentA;
        Student studentB;

        studentA = new Student(1, "hoang van A", true);
        studentB = new Student(2,"nguyen van A",true);

        studentA.printInfo();

        // sua ten sinh viên B
        studentB.setName("Nguyen van B");
        // hiển thị sinh viên B
        studentB.printInfo();
    }
}
