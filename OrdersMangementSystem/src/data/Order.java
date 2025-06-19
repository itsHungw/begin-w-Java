package data;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private String orderId;
    private String date;
    private String customerName;
    private String customerAddress;
    ArrayList<Product> list = new ArrayList();
    Scanner sc = new Scanner(System.in);

    public Order(String orderId, String date, String customerName, String customerAddress) {
        this.orderId = orderId;
        this.date = date;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void addNewProduct() {
        String name;
        String id;
        double price;
        System.out.println("------------------------");
        System.out.println("Add new product to list");
        System.out.print("Enter ID new product: ");
        id = sc.nextLine();
        System.out.print("Enter Name new product: ");
        name = sc.nextLine();
        System.out.print("Enter Price new product: ");
        price = Double.parseDouble(sc.nextLine());
        list.add(new Product(id, name, price));
    }

    private Product search(String idFind){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equalsIgnoreCase(idFind))
                return list.get(i);
        }
        return null;
    }

    public void updatePrice(){
        System.out.print("Enter ID product you want to UPDATE: ");
        String idFind = sc.nextLine();
        System.out.print("Enter new price: ");
        search(idFind).setPrice(sc.nextDouble());
        System.out.println("UPDATE price successfully!");
    }

    public void displayListProduct(){
        System.out.println("|Product ID     |Product Name   |Product Price  |");
        for(Product x : list)
            x.displayProduct();
    }
}
