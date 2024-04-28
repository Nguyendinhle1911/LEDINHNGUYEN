package com.example2.entity;

import java.util.Scanner;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private double mark;
    public Student() {
    }
    public Student(int id, String firstName, String lastName, double mark) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
    }
    public void scanInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        this.id = scanner.nextInt();
        System.out.println("Enter first name: ");
        this.firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        this.lastName = scanner.nextLine();
        System.out.println("Enter mark: ");
        this.mark = scanner.nextDouble();
    }
}
