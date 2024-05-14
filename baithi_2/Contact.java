package baithi_2;

public class Contact {
        private String name;
        private String company;
        private String email;
        private String phoneNumber;

        public Contact(String name, String company, String email, String phoneNumber) {
            this.name = name;
            this.company = company;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return String.format("%-20s%-20s%-20s%-15s", name, company, email, phoneNumber);
        }
    }

