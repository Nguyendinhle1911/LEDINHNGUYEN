package SESSION.session10.entity;

public class Customer {
  private int customerId;
  private String name;
  private String address;
  private String phone;

  public Customer(int customerId, String name, String address, String phone) {
    this.customerId = customerId;
    this.name = name;
    this.address = address;
    this.phone = phone;
  }

  // Getters and setters
  public int getCustomerId() {
    return customerId;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}


