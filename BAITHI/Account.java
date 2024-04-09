package BAITHI;


    import jdk.internal.icu.lang.UCharacterDirection;

    import java.util.Scanner;

    public class Account {
        private String customerCode;
        private String customerName;
        private int accNumber;
        private long amount;

        public Account() {
            this.amount = 0;
        }

        public void Input() {
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("Nhập mã khách hàng (5 ký tự): ");
                customerCode = scanner.next();
            } while (customerCode.length() != 5);

            scanner.nextLine();
            System.out.print("Nhập tên khách hàng: ");
            customerName = scanner.nextLine();

            do {
                System.out.print("Nhập số tài khoản (bắt đầu bằng ‘100’ và có 6 chữ số): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Đó không phải là một số nguyên hợp lệ!");
                    scanner.next();
                }
                accNumber = scanner.nextInt();
                if (accNumber < 100000 || accNumber > 999999) {
                    System.out.println("Số tài khoản phải bắt đầu bằng ‘100’ và có 6 chữ số. Vui lòng thử lại.");
                }
            } while (accNumber < 100000 || accNumber > 999999);

            System.out.println("Tạo tài khoản thành công!");
        }

        public void depositAndWithdraw(long money, int type) {
            if (type == 0 && money > 0) {
                amount += money;
                System.out.println("Gửi tiền thành công! Số dư hiện tại: " + amount);
            } else if (type == 1 && money > 0 && money <= amount) {
                amount -= money;
                System.out.println("Rút tiền thành công! Số dư hiện tại: " + amount);
            } else if (type == 1 && money > amount) {
                System.out.println("Số dư không đủ để rút. Vui lòng gửi thêm tiền.");
            } else {
                System.out.println("Số dư không đủ hoặc thao tác không hợp lệ.");
            }
        }

        @Override
        public String toString() {
            return STR."Mã Khách Hàng: \{customerCode}\nTên Khách Hàng: \{customerName}\nSố Tài Khoản: \{accNumber}\nSố Dư Tài Khoản: \{amount}";
        }
    }

