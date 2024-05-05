package session12;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class KeyValue <K,V>{
    private Map<K,V> map;



    public KeyValue() {
        this.map = new HashMap<>();
    }

    public void put(K key,V value){
        map.put(key,value);
    }
    public V get(K key){
        return map.get(key);
    }
    public Iterable<V> value(){
        return map.values();
    }
}
class Product{
    private int id;
    private String name;
    private double price;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Id:" +id +"\nName:"+name+" \nPrice:" +price;
    }
}
class Customer{
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Id: "+id+"\nName: "+name+"\nEmail: " +email;
    }

    public static void main(String[] args) {
        KeyValue<Integer,Product> productMap = new KeyValue<>();

        productMap.put(1,new Product(1,"apple24",9.99));
        productMap.put(2,new Product(2,"Nokia24",8.99));
        productMap.put(3,new Product(3,"Samsung24",7.99));
        KeyValue<Integer,Customer> customerMap = new KeyValue<>();
        customerMap.put(1,new Customer(1,"Nam","nam@gmail.com"));
        customerMap.put(2,new Customer(2,"Thu","thu@gmail.com"));
        customerMap.put(3,new Customer(3,"Hoa","hoa@gmail.com"));
        System.out.println("Customer list:");
        for (Customer customer : customerMap.value()){
            System.out.println(customer.toString());
        }
        System.out.println("=======================================");
        System.out.println("Product list:");
        for (Product product : productMap.value()){
            System.out.println(product.toString());
        }
    }
}


