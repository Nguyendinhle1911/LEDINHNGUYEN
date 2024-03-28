package LAP6;


public class MoreClass {
    public static <object> void main(String[] arg){
        object obj1 = new object();
        System.out.println(obj1);

        object obj2 = new object(){
            public String toString(){
                return"this ís obj2";
            }
        };
        System.out.println(obj2);
    }
}
