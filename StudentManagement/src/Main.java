
import data.Container;

public class Main {

    public static void main(String[] args) {
        Container SE = new Container("Software Engineer");
        SE.addStudent();
        SE.addStudent();

        Container GD = new Container("Graphic Design");
        GD.addStudent();
        GD.addStudent();

        SE.showStudentList();
        GD.showStudentList();

        GD.updateStudent();

    }
}