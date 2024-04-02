package session3;

public class AppName {
    public static void main(String[] args) {
        Dog quick = new Dog("phuc", 5 , 12);
        quick.getAnimalName();
        System.out.println("Name: "+ quick.getName());
        System.out.println("Animal name;"+ quick.getAnimalName());
        System.out.println("==========");
        // gọi các phương thức trên lớp dog
        System.out.println("Age: "+quick.getAge());
        System.out.println("Height"+quick.getHeight());




        // thể hiện tính đa hình

        Dog quick2 = new PhuQuocDog("PQ dog" , 3 , 130);
        System.out.println("Animal" +quick2.getAnimalName());

    }
}
