package session10.entities;

public class Product {
    private int productId;
    private String productName;
    private String productDesc;
    private Double price;

    public Product() {
    }

    public Product(int productId, String productName, String productDesc, Double price) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.price = price;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
