package LAP5.LAP5_EX3;

public class Main {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(1, 2, 3, 4);
        System.out.println(point.toString());
        point.moveUp();
        System.out.println(point.toString());

        MovableCircle circle = new MovableCircle(5, 6, 7, 8, 10);
        System.out.println(circle.toString());
        circle.moveLeft();
        System.out.println(circle.toString());
    }
}
