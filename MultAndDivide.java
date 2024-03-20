package academy;

public class MultAndDivide {
    public static void main(String[] args) {
        double subtotal = 30;
        double tax = 0.0875;
        double total = subtotal + (subtotal * tax);
        System.out.println("Total: " + total);
        double perPerson = total / 4;
        System.out.println("perPerson: " + perPerson);
    }

}
