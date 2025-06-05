import data.Container;
import data.Student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       Container tuSE = new Container("SE");


        int count = 0;
        String choice;
        do {
            menu();
            System.out.print("Enter your choice: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    tuSE.createStudent();
                    break;
                case "2":
                    tuSE.display();
                    break;
                case "3":
                    tuSE.search(sc);
                    break;
                case "4":
                    System.out.println("Exiting!....");
                    break;
                default:
                    System.out.println("IVALID NUMBER! TRY AGAIN: ");
                    break;
            }
        } while (!choice.equals("4"));
    }

    public static void menu(){
        System.out.println("___MENU___");
        System.out.println("1.Input");
        System.out.println("2.Output");
        System.out.println("3.Search");
        System.out.println("4.Exiting");
    }

}