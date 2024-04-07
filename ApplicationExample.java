package SESSION.session6;

import java.util.ArrayList;

public class ApplicationExample {
    public static <student> void main(String[] args){
        Student student = new Student(1,"ngoc",23);
        ArrayList<Student> listStudent = new ArrayList<>();

        listStudent.add(student);
        listStudent.add(new Student(2,"",19));
        listStudent.add(new Student(3,"phuc",19));
        listStudent.add(new Student(4,"da",19));
        listStudent.add(new Student(5,"vu",19));
        for (Student stu : listStudent){
            System.out.println(stu);
        }
        System.out.println("tim kiem sv");
        for (int i=0; i<listStudent.size(); i++){
            if (listStudent.get(i).name.contains("nguyen")){
                System.out.println(listStudent.get(i));
                listStudent.remove(listStudent.get(i));
            }
        }
        System.out.println("danh sach da xoa");
        for (Student stu2 : listStudent){
            System.out.println(stu2);
        }

    };

}
