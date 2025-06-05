package data;

import java.util.Scanner;

public class Container {
    private String label;
    private int count = 0;
    Student[] list = new Student[500];
    private Scanner sc = new Scanner(System.in);

    private String name;
    private String id;
    private int age;

    public Container(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void createStudent() {
        System.out.println("Student " +(count+1) +"/" +list.length );
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = Integer.parseInt(sc.nextLine());

        list[count] = new Student(name, id, age);
        count++;
    }

    public void display() {
        System.out.println("There is/are " +(count) +" Student in this major: ");
        for (int i = 0; i < count; i++) {
            list[i].output();
        }

    }

    public void search(Scanner sc){
        String idSearch = sc.nextLine();
        for (int i = 0; i < count; i++) {
            if(list[i].getId().equals(idSearch) == true){
                list[i].output();
                return;
            }
        }
        System.out.println("NOT FOUND!");
    }
}
