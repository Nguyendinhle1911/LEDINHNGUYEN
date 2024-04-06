package SESSION.session6;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void demoLinkedList(){
        // khoi tao linkedlist
        LinkedList<String> student = new LinkedList<>();
        // them dsanh sach
        student.add("nguyen");
        student.add(" phuc ");
        student.add(" d.anh");
        student.add(" huyen ");

        List<String> animal = new LinkedList<>();
        // ve co ban thi no tuong don cac phuong thuc trong array
        // add..,set...,get...
        //
        student.poll();
        // polllast () tra ve pt cuoi vs xoa khoi danh sach
        student.pollLast();
        showLink(student);
    }

    private static <args> void showLink( LinkedList<String> student) {
        demoLinkedList();
    }

}
