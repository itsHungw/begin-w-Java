import data.Order;

public class Main {
    public static void main(String[] args) {
        Order new1 = new Order("12345", "1/1/2000", "haha", "Ha noi");
        new1.addNewProduct();
        new1.addNewProduct();
        new1.displayListProduct();
    }
}