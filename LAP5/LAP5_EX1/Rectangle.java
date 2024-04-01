package LAP5.LAP5_EX1;

    public class Rectangle extends Shape{
        private final double length;
        private final double width;

        public Rectangle(String color, double length, double width) {
            super(color);
            this.length = length;
            this.width = width;
        }

        @Override
        public double getArea() {
            return width * length;
        }
    }

