package data;

public class Product {
    private String name;
    private String id;
    private double price;

    public Product(String id, String name, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayProduct(){
        System.out.printf("|%-15s|%-15s|%-15.1f|\n", id, name, price);

    }
}
