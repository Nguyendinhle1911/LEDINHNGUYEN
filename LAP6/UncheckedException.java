package LAP6;

public class UncheckedException {
    public UncheckedException (){
        // To do :
    }
    public static void main (String[] args) {
        int i, n = 2;
        int[] a = new int [n];
        // declare scanner object named input
        java.util.Scanner input = new java.util.Scanner(System.in);

        for(i=0; i<=n; i++) {
            System.out.printf("a[%d] = ", i);
            a[i] = input.nextInt();
        }
    }
}


