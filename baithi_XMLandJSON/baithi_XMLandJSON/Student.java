package baithi_XMLandJSON;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String address;
    private String email;
    private int phone;
    private Date DOD;

    public Student(int id, String name, String address, String email, int phone, Date DOD) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.DOD = DOD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Date getDOD() {
        return DOD;
    }

    public void setDOD(Date DOD) {
        this.DOD = DOD;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", DOD=" + DOD +
                '}';
    }
}
