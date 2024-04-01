package LAP5.LAP5_EX3;

public class MovablePoint extends Movable {
    private int x;
    private int y;
    private int xSeepd;
    private  int ySeepd;

    public MovablePoint(int x, int y, int xSeepd, int ySeepd) {
        this.x = x;
        this.y = y;
        this.xSeepd = xSeepd;
        this.ySeepd = ySeepd;
    }

    @Override
    public void moveUp() {
        y -= ySeepd;
    }

    @Override
    public void moveDown() {
        y += ySeepd;
    }

    @Override
    public void moveLeft() {
        x += xSeepd;
    }

    @Override
    public void moveRight() {
        x += xSeepd;
    }

    @Override
    public String toString() {
        return "MovablePoint at (" + x + ", " + y + ")";
    }
}
