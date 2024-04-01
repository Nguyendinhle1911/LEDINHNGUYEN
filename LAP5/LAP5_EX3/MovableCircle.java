package LAP5.LAP5_EX3;

    public class MovableCircle extends Movable {
        private int radius;
        MovablePoint center;

        public MovableCircle(int radius, int x,int y, int xSeepd, int ySeepd) {
            this.radius = radius;
            this.center = new MovablePoint(x,y,xSeepd,ySeepd);
        }

        @Override
        public void moveUp() {
            center.moveUp();
        }

        @Override
        public void moveDown() {
            center.moveDown();
        }

        @Override
        public void moveLeft() {
            center.moveLeft();
        }

        @Override
        public void moveRight() {
            center.moveRight();
        }

        @Override
        public String toString() {
            return "MovableCircle with center at " + center.toString() + " and radius " + radius;
        }
}
