package LAP04;

public class Cylinder extends Circle{
    int height;

    public Cylinder(double radius, String color,int height) {
        super(radius, color);
        this.height = height;

    }

    public int getHeight() {
        return height;
    }
    public double getVolume(){
        return getArea()*height;
    }
}
