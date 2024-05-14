package session12.entity;

public class Entity {
    private String name;
    private String Company;
    private int phone;
    private String email;


    public Entity() {

    }

    public Entity(String name, String company, String email, int phone) {
        this.name = name;
        Company = company;
        this.email = email;
        this.phone = phone;
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

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

