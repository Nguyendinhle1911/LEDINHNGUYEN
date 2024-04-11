package com.example.entity;

public class Employee {
    private String name;
    private  int age;
    private int employeeId;

    public Employee(String name, int age, int employeeId) {
        super();
        this.name = name;
        this.age = age;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", employeeId=" + employeeId +
                '}';
    }
}
