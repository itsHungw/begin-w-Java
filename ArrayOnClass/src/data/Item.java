package data;

import java.util.Scanner;

public class Item {
    protected int value;
    protected String creator;
    Scanner sc =  new Scanner(System.in);

    public Item() {
    }

    public Item(String creator, int value) {
        this.creator = creator;
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void input(){
        value = Integer.parseInt(sc.nextLine());
        creator = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Item{" +
                "creator='" + creator + '\'' +
                ", value=" + value +
                '}';
    }

    public void output(){
        System.out.print(creator +" - " +value +" - ");
    }
}
