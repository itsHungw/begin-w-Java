import data.Painting;
import data.Statue;
import data.Vase;
import jdk.jshell.VarSnippet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vase v1 = new Vase();
        Statue s1 = new Statue();
        Painting p1 = new Painting();
        v1.input();
        v1.output();

        s1.input();
        s1.output();


    }
}