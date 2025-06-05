/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programclass;

import data.Student;
import java.util.Scanner;

public class ProgramClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of student: ");
        int n = Integer.parseInt(sc.nextLine());
        Student[] students = new Student[n];
        String choice;

        do {
            System.out.println("---MENU---");
            System.out.println("1.Input");
            System.out.println("2.Display");
            System.out.println("3.Exit");
            choice = sc.nextLine();

            switch (choice) {
                case "1": {
                    for (int i = 0; i < students.length; i++) {
                        students[i] = input(sc);
                    }
                }
                break;
                case "2": {
                    sort(students);
                    for (int i = 0; i < students.length; i++) {
                        students[i].output();
                    }
                }
                break;
                case "3":
                    System.out.println("Exitting!...");
                    break;

                default:
                    System.out.println("Invalid choice!..");
            }
        } while (!choice.equals("3"));
    }

    public static Student input(Scanner sc) {

        System.out.print("Enter your code: ");
        String code = sc.nextLine();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter year of birth: ");
        int bYear = Integer.parseInt(sc.nextLine());

        System.out.print("Enter address: ");
        double mark = Double.parseDouble(sc.nextLine());

        return new Student(code, name, bYear, mark);
    }

    public static void sort(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length; j++) {
                if (students[i].getMark() < students[j].getMark()) {
                    Student temp;
                    temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }

            }
        }
    }
}

