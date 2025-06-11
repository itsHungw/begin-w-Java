
import data.Container;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Container SE = new Container("Software Engineer");
        Container GD = new Container("Graphic Design");
        String choice;
        String option;
        do {
            menu();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Option 1: Add SE student");
                    System.out.println("Option 2: Add GD student");
                    option = sc.nextLine();
                    switch (option) {
                        case "1":
                            SE.addStudent();
                            break;
                        case "2":
                            GD.addStudent();
                    }
                    break;
                case "2":
                    System.out.println("Option 1: List SE student");
                    System.out.println("Option 2: List GD student");
                    System.out.println("Option 3: List ALL student");
                    option = sc.nextLine();
                    switch (option) {
                        case "1":
                            SE.showStudentList();
                            break;
                        case "2":
                            GD.showStudentList();
                            break;
                        case "3":
                            SE.showStudentList();
                            GD.showStudentList();
                            break;
                    }
                    break;

                case "3":
                    System.out.println("Option 1: Find SE student");
                    System.out.println("Option 2: Find GD student");
                    option = sc.nextLine();
                    switch (option) {
                        case "1":
                            SE.searchStudent();
                            break;
                        case "2":
                            GD.searchStudent();
                    }
                    break;

                case "4":
                    System.out.println("Option 1: Update SE student GPA");
                    System.out.println("Option 2: Update GD student GPA");
                    option = sc.nextLine();
                    switch (option) {
                        case "1":
                            SE.updateStudent();
                            break;
                        case "2":
                            GD.updateStudent();
                    }
                    break;

                case "5":
                    System.out.println("Option 1: REMOVE student from SE List");
                    System.out.println("Option 2: REMOVE student from GD List");
                    option = sc.nextLine();
                    switch (option) {
                        case "1":
                            SE.removeStudent();
                            break;
                        case "2":
                            GD.removeStudent();
                    }
                    break;

                case "0":
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Invalid, enter again");
            }
        } while (!choice.equalsIgnoreCase("0"));
    }


    public static void menu() {
        System.out.println("___MENU___");
        System.out.println("1.Add");
        System.out.println("2.Display");
        System.out.println("3.Find");
        System.out.println("4.Update");
        System.out.println("5.Delete");
        System.out.println("0.Exit");
        System.out.print("Enter your choice: ");
    }
}