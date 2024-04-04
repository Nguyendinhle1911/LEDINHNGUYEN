package SESSION.session5;
import java.util.Scanner;

public class IntegerArrayDemo {
    Scanner scanner = new Scanner(System.in);
    public static void createArray(int arr[]){
        for(int i = 0; i < arr.length;i++){
            System.out.println("nhập pt vào array"+i+".");
            arr[i] = scanner.nextInt();        }
    }
    public void show(int arr[]){
        for(int i = 0; i < arr.length;i++){
            System.out.println(arr[i]+"\t");
        }
    }
    public void ascSort(int arr[]){}
}
