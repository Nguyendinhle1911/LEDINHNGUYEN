package session3;

public class Dog extends Animal{
    private int age;
    private int height;

    public Dog(String name, int age, int height) {
        //goi tới constructor của lớp Animal
        //giá trị của Field trong lớp cha sẽ được gán
        //contructor public Animal(String name) se duoc goi va gan gia tri
        super(name);
        //sau đó giá trị Field trong lớp con mới được gán
        this.age = age;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override //thực hiện triển khai phương thức abstract
    public String getAnimalName() {
        return "Dog";
    }


}