package data;

import java.util.ArrayList;
import java.util.Scanner;

public class Container {
    private String major;
    ArrayList<Student> arr = new ArrayList();
    Scanner sc = new Scanner(System.in);

    public Container(String major) {
        this.major = major;
    }

    public void addStudent() {
        System.out.println("INPUT STUDENT " + major.toUpperCase() + " MAJORITY #" + (arr.size() + 1));
        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim().toUpperCase();

//check ID có bị trùng ko
        String id;
        while (true) {
            System.out.print("Enter student ID: ");
            id = sc.nextLine().trim().toUpperCase();
            Student xx = searchStudent(id);
            if (xx == null)
                break;
            else
                System.out.print("Duplicate ID ! Enter again: ");
        }

        System.out.print("Enter student GPA: ");
        double gpa = Double.parseDouble(sc.nextLine());

        arr.add(new Student(name, id, gpa));
        System.out.println("New student have been added successfully !!!");
    }

    public void showStudentList() {
        if (arr.isEmpty())
            System.out.println("The List of " +major +" is EMPTY !!!");
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i).getGpa() < arr.get(j).getGpa()) {
                    Student tmp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, tmp);
                }
            }
        }
        System.out.println(major.toUpperCase() + " have " + arr.size() + " student(s): ");
        for (Student x : arr) {
            x.showProfile();
        }
    }

    //Search return obj
    private Student searchStudent(String indexID) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getId().equalsIgnoreCase(indexID))
                return arr.get(i);
        }
        return null;
    }

    public void searchStudent() {
        if (arr.isEmpty())
            System.out.println("LIST IS EMPTY !!");
        System.out.print("Enter ID student want to FIND: ");
        String indexID = sc.nextLine();
        Student x = searchStudent(indexID); //reuse Search return obj
        if (x == null)
            System.out.println("NOT FOUND !!");
        else {
            System.out.println("Student founded: ");
            x.showProfile();
        }
    }

    public void updateStudent() {
        System.out.print("Enter ID student want to UPDATE: ");
        String indexID = sc.nextLine();
        Student x = searchStudent(indexID); //reuse Search return obj
        if (x == null)
            System.out.println("NOT FOUND !!");
        else {
            System.out.print("Update student GPA: ");
            double newGPA = Double.parseDouble(sc.nextLine());
            x.setGpa(newGPA);
            x.showProfile();
        }
    }

    public void removeStudent() {
        System.out.print("Enter ID student want to REMOVE: ");
        String indexID = sc.nextLine();
        Student x = searchStudent(indexID); //reuse Search return obj
        if (x == null)
            System.out.println("NOT FOUND !!");
        else {
            x.showProfile();
            String choose;
            do {
                System.out.println("REMOVE student ? Yes/No");
                System.out.println("1. YES");
                System.out.println("2. NO");
                choose = sc.nextLine();
                switch (choose) {
                    case "1":
                        arr.remove(x);
                        System.out.println("REMOVE students " +x.getId() +" successfully");
                        break;
                    default:
                        System.out.print("Error, Enter again: ");
                }
            } while (choose.equalsIgnoreCase("2"));


        }
    }
}
