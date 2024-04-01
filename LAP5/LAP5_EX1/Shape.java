package LAP5.LAP5_EX1;

public abstract class Shape {
   private String color;

   public Shape(String color){
       this.color = color;
   }
   public String getColor(){
       return color;
   }
   public abstract double getArea();
}
