package LAP5.LAP5_EX1;

public class TestShape {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("do",3, 10);
        Triangle triangle = new Triangle("vang", 2, 6);

        System.out.println("Area of Rectangle: " + rectangle.getArea());
        System.out.println("Area of Triangle: " + triangle.getArea());
    }
}