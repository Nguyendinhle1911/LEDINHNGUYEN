package LAP.LAP5_1;
 import java.util.*;
public class PlanetDiameters {
    // mảng tên các hành tinh
 private static final String [] names ={"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "đinhnguyen" };
 //Mảng đường kính các hành tinh
 private static final float [] diameters = { 4800f, 12103.6f, 12756.3f, 6794f, 142984f, 120536f, 51118f, 49532f, 1911f };

 public static void main(String[] args){
  //Sử dụng Map để lưu trữ tên các hành tinh và tên tương ứng của chúng
  //đường kính
  Map planets = new HashMap();


  // Thêm các mục (key , value) vào bản đồ
  for (int i = 0; i < names.length; i++)
  planets.put(names[i], diameters[i]);

  // Đi qua bản đồ
  Iterator it = planets.entrySet().iterator();
  while (it.hasNext()) {
   Map.Entry e = (Map.Entry) it.next();
   System.out.println(e.getKey() + ": " + e.getValue());
  }

  System.out.println("--------------------");

// Tìm hành tinh theo tên dựa vào key
  while (true) {
   System.out.print("Find planet (ENTER to quit): ");

   String name = (new Scanner(System.in)).nextLine();

   if (name.length() == 0) break;

   if (!planets.containsKey(name))

    System.out.println("Planet " + name + " not found!");
   else
    System.out.println("The diameter of " + name +
            " is " + planets.get(name));
  }





 }


}
