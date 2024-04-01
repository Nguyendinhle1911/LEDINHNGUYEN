package LAP5.LAP5_EX2;

public class main {
    public static void main(String[] args) {
        MovablePoint sodo = new MovablePoint(5,6);
        sodo.moveDown();
        System.out.println("After moving down: (" + sodo.getX() + ", " + sodo.getY() + ")");
        sodo.moveUp();
        System.out.println("After moving up: (" + sodo.getX() + ", " + sodo.getY() + ")");
        sodo.moveLeft();
        System.out.println("After moving left: (" + sodo.getX() + ", " + sodo.getY() + ")");
        sodo.moveRight();
        System.out.println("After moving right: (" + sodo.getX() + ", " + sodo.getY() + ")");

    }
}