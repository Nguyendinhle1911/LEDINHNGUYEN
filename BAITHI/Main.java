package BAITHI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.Input();


        Scanner scanner = new Scanner(System.in);
        boolean continueTransaction = true;
        while (continueTransaction) {
            System.out.print("Bạn muốn gửi tiền(0), rút tiền(1) hay thoát(2)? ");
            int type = scanner.nextInt();

            if (type == 2) {
                continueTransaction = false;
                break;
            }

            if (type != 0 && type != 1) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }

            System.out.print("Nhập số tiền cho giao dịch: ");
            long money = scanner.nextLong();

            account.depositAndWithdraw(money, type);
            System.out.println(account.toString());
        }
    }
}
