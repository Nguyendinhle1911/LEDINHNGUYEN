package SESSION.session6;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {


    public static void arrayListMethod(){
        // ArrayList tao bang hai cach
        //cach 1:
        ArrayList<String> student = new ArrayList<>();

        //cach 2:
        List<String> animal = new ArrayList<>();

        //them phan tu vao ArrayList
        student.add("ngoc");
        student.add("anh");
        student.add("minh");
        student.add("thao");
        student.add("nguyen");

        //hien thi thong tin
        //System.out.println(student);
        // display(student);

        show(student);
        System.out.println("===============");
        student.add(2,"phuc");
        display(student);
        System.out.println("===============");
        int size = student.size();
        System.out.println("so luong " + size);
        System.out.println("===============");

        //lay ra mot phan tu theo index
        String st = student.get(1);

        // lay phan tu dau tien
        String fistStudent = student.getFirst();// getLast()
        System.out.println("sv dau tien : "+fistStudent);

        //sua gia tri
        student.set(3, "new name at in dex 3");
        System.out.println("the final list affer updated");
        display(student);
        System.out.println("===============");

        //xoa phan tu dau tien va lay ra
        String first = student.removeFirst();//removeLast()
        // xoa toan bo
        student.clear();
        size = student.size();
        System.out.println("ArrayList sau khi clear : " + size);
        System.out.println(" List sau khi clear ");
        display(student);
        System.out.println("===============");

    }
    public static void display(ArrayList list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void show(ArrayList list){
        for (Object arrlist : list){
            System.out.println(arrlist);
        }
    }

    public static void main(String[] args) {

        arrayListMethod();
    }

}