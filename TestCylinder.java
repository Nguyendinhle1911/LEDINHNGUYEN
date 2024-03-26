package LAP04;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(3.0, "Blue", 5);

        System.out.println("Cylinder radius: " + cylinder.getRadius());
        System.out.println("Cylinder color: " + cylinder.getColor());
        System.out.println("Cylinder height: " + cylinder.getHeight());
        System.out.println("Cylinder volume: " + cylinder.getVolume());
    }
}
